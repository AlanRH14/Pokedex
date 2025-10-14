package com.example.pokedex.presentation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.pokedex.domain.models.Pokemon
import java.util.Locale

@Composable
fun PokemonItem(
    pokemon: Pokemon,
    onEvent: (PokemonUIEvent) -> Unit
) {
    val imgRequest = ImageRequest.Builder(LocalContext.current)
        .data(pokemon.url)
        .crossfade(true)
        .build()

    Card(
        modifier = Modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onBackground
        ),
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(4.dp),
        onClick = { onEvent(PokemonUIEvent.OnClickPokemonDetail(pokemonName = pokemon.name)) }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.background(Color.Transparent)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(1F)
                        .alpha(8F),
                    textAlign = TextAlign.Center,
                    text = pokemon.name,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                )

                Text(
                    modifier = Modifier.alpha(0.5F),
                    text = pokemon.id,
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.2f)
                    .fillMaxHeight(),
                model = imgRequest,
                onError = {
                    Log.d("LordMiau", "Error Image: ${it.result.throwable.message}")
                },
                contentScale = ContentScale.Fit,
                contentDescription = "Image ${pokemon.name}",
            )
        }
    }
}