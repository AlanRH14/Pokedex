package com.example.pokedex.presentation.screens.pokedex

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.example.pokedex.navigation.NavRoute
import com.example.pokedex.presentation.components.HandlerPagingResult
import com.example.pokedex.presentation.screens.pokedex.components.PokemonItem
import com.example.pokedex.presentation.screens.pokedex.mvi.PokemonEffect
import com.example.pokedex.presentation.screens.pokedex.mvi.PokemonUIEvent
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@Composable
fun PokedexScreen(
    modifier: Modifier,
    viewModel: PokedexViewModel = koinViewModel(),
    navController: NavHostController
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val pokemons = state.pokemonList.collectAsLazyPagingItems()
    val result = HandlerPagingResult(pokemons = pokemons)

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
            .padding(16.dp)
            .fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            if (result) {
                items(count = pokemons.itemCount, key = pokemons.itemKey { it.id }) { pokemonIndex ->
                    pokemons[pokemonIndex]?.let { pokemon ->
                        PokemonItem(
                            pokemon = pokemon,
                            pokemonState = state,
                            onEvent = viewModel::onEvent
                        )
                    }
                }
            }
        }

        if (!state.errorMessage.isNullOrEmpty()) {
            Text(state.errorMessage ?: "")
        }
    }
}