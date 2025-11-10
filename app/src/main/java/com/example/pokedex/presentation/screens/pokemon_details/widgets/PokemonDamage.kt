package com.example.pokedex.presentation.screens.pokemon_details.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.presentation.screens.pokemon_details.components.PokemonTypeItem

@Composable
fun PokemonDamage(
    damages: Map<Double, List<String>>? = null,
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
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(types) { type ->
                    PokemonTypeItem(
                        types = type,
                        color = color
                    )
                }
            }
        }
    }
}