package com.example.pokedex.presentation.screens.pokemon_details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.PrimaryTabRow
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pokedex.domain.models.PokemonDetail
import com.example.pokedex.navigation.DestinationTabs
import com.example.pokedex.navigation.InformationTabsHost
import com.example.pokedex.presentation.screens.pokemon_details.mvi.PokemonDetailUIEvent

@Composable
fun PokemonTabsInfo(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    pokemonDetail: PokemonDetail? = null,
    onEvent: (PokemonDetailUIEvent) -> Unit
) {
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
                            selectedDestination = index
                            onEvent(PokemonDetailUIEvent.OnClickTabNavigation(route = destination.route))
                        }
                    ) {
                        Text(
                            text = destination.title,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            },
        )

        HorizontalPager(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 8.dp),
            state = pagerState,
        ) {
            InformationTabsHost(
                navController = navController,
                pokemonDetail = pokemonDetail,
                onEvent = onEvent
            )
        }
    }
}