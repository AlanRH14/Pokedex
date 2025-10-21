package com.example.pokedex.presentation.screens.pokemon_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.navigation.DestinationTabs
import com.example.pokedex.navigation.InformationTabsHost
import com.example.pokedex.presentation.screens.pokemon_details.mvi.PokemonDetailUIEvent
import org.koin.core.definition.indexKey

@Composable
fun PokemonTabsInfo(
    modifier: Modifier = Modifier,
    onEvent: (PokemonDetailUIEvent) -> Unit
) {
    val navController = rememberNavController()
    val startDestination = DestinationTabs.INFORMATION
    val pagerState = rememberPagerState { DestinationTabs.entries.size }
    var selectedDestination by rememberSaveable { mutableIntStateOf(startDestination.ordinal) }

    Column(modifier = modifier) {
        PrimaryTabRow(
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

        HorizontalPager(
            modifier = Modifier
                .fillMaxSize(),
            state = pagerState,
        ) {
            InformationTabsHost(navController = navController)
        }
    }
}