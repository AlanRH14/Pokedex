package com.example.pokedex.presentation.screens.pokemon_details.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.domain.models.Species
import com.example.pokedex.presentation.screens.pokemon_details.components.AboutIntoItem

@Composable
fun PokemonAbout(
    species: Species?
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = species?.description ?: "Unknown",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        AboutIntoItem(
            title = "Habitat:",
            description = species?.habitat ?: "Unknown"
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AboutIntoItem(
                modifier = Modifier.weight(0.5F),
                title = "Happiness:",
                description = "${species?.baseHappiness ?: "Unknown"}"
            )

            AboutIntoItem(
                modifier = Modifier.weight(0.5F),
                title = "Capture Rate:",
                description = "${species?.captureRate ?: "Unknown"}"
            )
        }
    }
}