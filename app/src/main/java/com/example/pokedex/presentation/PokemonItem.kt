package com.example.pokedex.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

    }
}