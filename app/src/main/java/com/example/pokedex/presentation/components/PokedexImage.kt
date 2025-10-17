package com.example.pokedex.presentation.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade

@Composable
fun PokemonImage(
    modifier: Modifier = Modifier,
    image: String,
    contentScale: ContentScale = ContentScale.Fit,
    colorFilter: ColorFilter? = null,
    contentDescription: String? = null,
) {

    val imageRequest = ImageRequest.Builder(LocalContext.current)
        .data(image)
        .crossfade(true)
        .build()

    AsyncImage(
        modifier = modifier,
        model = imageRequest,
        onError = {
            Log.d("LordMiau", "Error Image: ${it.result.throwable.message}")
        },
        contentScale = contentScale,
        colorFilter = colorFilter,
        contentDescription = contentDescription,
    )
}