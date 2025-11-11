package com.example.pokedex.presentation.screens.pokemon_details.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.domain.models.Type

@Composable
fun PokemonDamage(
    damages: Map<Double, List<Type>>? = null,
    color: Int
) {
    if (damages == null) return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        damages.entries.forEach { (damage, types) ->
            Text(text = "x$damage")

            PokemonTypes(
                types = types,
                color = color
            )
        }
    }
}