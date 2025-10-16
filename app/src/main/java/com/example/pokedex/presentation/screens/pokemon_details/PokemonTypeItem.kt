package com.example.pokedex.presentation.screens.pokemon_details

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pokedex.utils.DrawableUtils.icon

@Composable
fun PokemonTypes(ability: String) {
    Row(
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
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(14.dp),
            painter = painterResource(id = ability.icon),
            contentDescription = "Icon $ability",
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = ability,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}