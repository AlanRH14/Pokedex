package com.example.pokedex.presentation.screens.pokemon_details.widgets

import androidx.compose.animation.core.repeatable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.presentation.screens.pokemon_details.components.PokemonTypes

@Composable
fun PokemonDamage(damage: Map<String, Double>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        damage.entries.forEach { damage ->
            Text(text = "x${damage.value}")
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items()
                PokemonTypes(
                    types = damage.fil
                )
            }
        }
    }
}