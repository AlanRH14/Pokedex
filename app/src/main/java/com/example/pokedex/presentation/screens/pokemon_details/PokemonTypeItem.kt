package com.example.pokedex.presentation.screens.pokemon_details

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PokemonTypeItem(ability: String) {
    Text(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.White,
                shape = CircleShape
            )
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
        text = ability,
        color = Color.White,
        style = MaterialTheme.typography.bodyLarge,
    )
}