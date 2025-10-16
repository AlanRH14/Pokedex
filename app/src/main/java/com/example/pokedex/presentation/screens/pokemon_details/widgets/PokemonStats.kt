package com.example.pokedex.presentation.screens.pokemon_details.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.domain.models.Stat
import com.example.pokedex.presentation.screens.pokemon_details.components.PokemonStatItem

@Composable
fun PokemonStats(
    modifier: Modifier = Modifier,
    stats: List<Stat>
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 32.dp,
                vertical = 16.dp
            ),
    ) {
        stats.forEach { stat ->
            key(stat.name) {
                PokemonStatItem(stat = stat)
            }
        }
    }
}