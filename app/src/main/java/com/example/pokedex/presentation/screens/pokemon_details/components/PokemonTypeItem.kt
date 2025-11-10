package com.example.pokedex.presentation.screens.pokemon_details.components

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
fun PokemonTypeItem(
    types: String,
    color: Int,
) {
    val colorPalette = Color(color)
    Row(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = colorPalette,
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
            painter = painterResource(id = types.icon),
            tint = colorPalette,
            contentDescription = "Icon $types",
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = types,
            color = colorPalette,
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}