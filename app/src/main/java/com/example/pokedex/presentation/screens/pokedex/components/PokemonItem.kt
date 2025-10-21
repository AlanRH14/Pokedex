package com.example.pokedex.presentation.screens.pokedex.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.presentation.components.PokemonImage
import com.example.pokedex.presentation.screens.pokedex.mvi.PokemonUIEvent
import com.example.pokedex.utils.animationShimmerItem

@Composable
fun PokemonItem(
    pokemon: Pokemon,
    onEvent: (PokemonUIEvent) -> Unit
) {
    LaunchedEffect(key1 = pokemon.id) {
        if (pokemon.colorPalette == null) {
            onEvent(PokemonUIEvent.OnPokemonItemVisible(pokemon = pokemon))
        }
    }

    val domainColor = Color(pokemon.colorPalette?.domainColor ?: Color.Transparent.hashCode())
    val onDomainColor = Color(pokemon.colorPalette?.onDominantColor ?: Color.White.hashCode())

    Card(
        modifier = Modifier,
        colors = CardDefaults.cardColors(
            containerColor = domainColor,
            contentColor = MaterialTheme.colorScheme.onBackground
        ),
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(4.dp),
        onClick = { onEvent(PokemonUIEvent.OnClickPokemonDetail(pokemonName = pokemon.name)) }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(Color.Transparent)
                .padding(4.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(1F),
                    text = pokemon.name,
                    textAlign = TextAlign.Center,
                    color = onDomainColor.copy(alpha = 0.8F),
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                )

                Text(
                    text = pokemon.id,
                    textAlign = TextAlign.End,
                    color = onDomainColor.copy(alpha = 0.5F),
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            PokemonImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.2f)
                    .fillMaxHeight(),
                image = pokemon.url,
                contentScale = ContentScale.Fit,
                contentDescription = "Image ${pokemon.name}",
            )
        }
    }
}