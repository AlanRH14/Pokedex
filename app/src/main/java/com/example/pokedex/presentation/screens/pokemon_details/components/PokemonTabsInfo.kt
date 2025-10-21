package com.example.pokedex.presentation.screens.pokemon_details.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.example.pokedex.navigation.DestinationTabs
import com.example.pokedex.presentation.screens.pokemon_details.mvi.PokemonDetailUIEvent
import org.koin.core.definition.indexKey

@Composable
fun PokemonTabsInfo(
    modifier: Modifier = Modifier,
    onEvent: (PokemonDetailUIEvent) -> Unit
) {
    val startDestination = DestinationTabs.INFORMATION
    var selectedDestination by rememberSaveable { mutableIntStateOf(startDestination.ordinal) }

    Scaffold(modifier = modifier) { contentPadding ->
        PrimaryTabRow(
            modifier = Modifier.padding(contentPadding),
            selectedTabIndex = selectedDestination,
            containerColor = TabRowDefaults.primaryContainerColor,
            contentColor = TabRowDefaults.primaryContentColor,
            tabs = {
                DestinationTabs.entries.forEachIndexed { index, destination ->
                    Tab(
                        selected = selectedDestination == index,
                        onClick = {
                            onEvent
                            selectedDestination = index
                        }
                    ) {
                        Text(
                            text = destination.text,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            },
        )
    }
}