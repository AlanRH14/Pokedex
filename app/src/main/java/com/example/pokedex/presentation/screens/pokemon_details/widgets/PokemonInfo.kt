package com.example.pokedex.presentation.screens.pokemon_details.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pokedex.R
import com.example.pokedex.presentation.screens.pokemon_details.PokemonInfoItem

@Composable
fun PokemonInfo(
    weight: Float,
    height: Float,
) {
    Card(
        modifier = Modifier
            .padding(
                horizontal = 32.dp,
                vertical = 16.dp
            ),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.outline.copy(.2F),
        )
    ) {
        Row(
            modifier = Modifier
                .padding(
                    horizontal = 12.dp,
                    vertical = 16.dp
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            PokemonInfoItem(
                modifier = Modifier.weight(1F),
                icon = painterResource(R.drawable.ic_scale),
                textInfo = "$weight kg",
                title = "Weight",
                contentDescription = "Icon Weight",
            )

            VerticalDivider(
                modifier = Modifier.height(30.dp),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.outline
            )

            PokemonInfoItem(
                modifier = Modifier.weight(1F),
                iconModifier = Modifier.rotate(90F),
                icon = painterResource(R.drawable.ic_straighten),
                textInfo = "$height m",
                title = "Height",
                contentDescription = "Icon Height"
            )
        }
    }
}