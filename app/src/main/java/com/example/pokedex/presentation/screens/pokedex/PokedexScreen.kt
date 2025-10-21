package com.example.pokedex.presentation.screens.pokedex

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.pokedex.navigation.NavRoute
import com.example.pokedex.presentation.screens.pokedex.components.PokemonItem
import com.example.pokedex.presentation.screens.pokedex.mvi.PokemonEffect
import com.example.pokedex.presentation.screens.pokedex.mvi.PokemonUIEvent
import com.example.pokedex.utils.animationShimmerItem
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@Composable
fun PokedexScreen(
    modifier: Modifier,
    viewModel: PokedexViewModel = koinViewModel(),
    navController: NavHostController
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        viewModel.onEvent(PokemonUIEvent.OnGetPokemonList)
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                is PokemonEffect.NavigateToPokemonDetail -> {
                    navController.navigate(NavRoute.PokemonDetailScreen(pokemonName = effect.pokemonName))
                }
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            if (state.isLoading) {
                items(20) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .background(Color.Transparent)
                            .padding(4.dp)
                            .animationShimmerItem(isLoading = true)
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .weight(1F)
                                    .height(22.dp)
                                    .animationShimmerItem(isLoading = true),
                            )

                            Box(
                                modifier = Modifier
                                    .height(16.dp)
                                    .animationShimmerItem(isLoading = true),
                            )
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1.2f)
                                .fillMaxHeight()
                                .animationShimmerItem(isLoading = true),
                        )
                    }
                }
            } else {
                items(state.pokemonList, key = { it.name }) { pokemon ->
                    PokemonItem(
                        pokemon = pokemon,
                        onEvent = viewModel::onEvent
                    )
                }
            }
        }

        if (!state.errorMessage.isNullOrEmpty()) {
            Text(state.errorMessage ?: "")
        }
    }
}