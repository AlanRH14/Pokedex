package com.example.pokedex.presentation.screens.pokemon_details.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.domain.models.Type
import com.example.pokedex.presentation.screens.pokemon_details.components.PokemonTypeItem

@Composable
fun PokemonTypes(
    modifier: Modifier = Modifier,
    color: Int,
    types: List<Type>
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(types, key = { it.type }) { ability ->
            PokemonTypeItem(
                types = ability.type,
                color = color
            )
        }
    }
}