package com.example.pokedex.presentation.screens.pokemon_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pokedex.R

@Composable
fun PokemonInfo(
    weight: Long,
    height: Long,
) {

    Card {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            PokemonInfoItem(
                icon = painterResource(R.drawable.ic_favorite_border),
                textInfo = "$weight kg",
                title = "Weight",
                contentDescription = "Icon Weight",
            )

            // VerticalDivider(thickness = 1.dp)

            PokemonInfoItem(
                icon = painterResource(R.drawable.ic_favorite_border),
                textInfo = "$height m",
                title = "Height",
                contentDescription = "Icon Height"
            )
        }
    }
}