package com.example.pokedex.presentation.screens.pokemon_details.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.example.pokedex.presentation.screens.pokemon_details.mvi.PokemonDetailUIEvent

@Composable
fun PokemonTabsInfo(
    modifier: Modifier = Modifier,
    onEvent: (PokemonDetailUIEvent) -> Unit
) {
    val selectedDestination by rememberSaveable { mutableStateOf() }

    Scaffold(modifier = modifier) { contentPadding ->
        PrimaryTabRow(
            modifier = Modifier.padding(contentPadding),
            selectedTabIndex = selectedTabIndex,
            containerColor = TabRowDefaults.primaryContainerColor,
            contentColor = TabRowDefaults.primaryContentColor,
            tabs = {},
        )
    }
}