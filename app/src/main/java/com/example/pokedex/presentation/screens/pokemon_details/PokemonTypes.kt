package com.example.pokedex.presentation.screens.pokemon_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.domain.models.Type

@Composable
fun PokemonTypeItem(
    modifier: Modifier = Modifier,
    abilities: List<Type>
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(abilities, key = { it.slot }) { ability ->
            PokemonAbilityItem(ability = ability.type)
        }
    }
}