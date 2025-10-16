package com.example.pokedex.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale

@Composable
fun PokemonImage(
    modifier: Modifier = Modifier,
    image: String,
    placeHolder: @Composable () -> Unit = {},
    contentScale: ContentScale = ContentScale.Fit,
    contentDescription: String? = null
) {

}