package com.example.pokedex.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import coil3.compose.AsyncImage
import com.example.pokedex.domain.models.Pokemon

@Composable
fun PokemonItem(
    pokemon: Pokemon,
    onEvent: (PokemonUIEvent) -> Unit
) {

    Card(
        modifier = Modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onBackground
        ),
        onClick = { onEvent(PokemonUIEvent.OnClickPokemonDetail(pokemonName = pokemon.name)) }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.2F)
                    .fillMaxHeight(),
                model = pokemon.url,
                contentDescription = "Image ${pokemon.name}",
                contentScale = ContentScale.Fit
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .alpha(8F),
                text = pokemon.name.uppercase(),
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
            )
        }
    }
}