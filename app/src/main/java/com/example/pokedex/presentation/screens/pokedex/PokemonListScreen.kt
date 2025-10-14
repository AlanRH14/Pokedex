package com.example.pokedex.presentation.screens.pokedex

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.pokedex.presentation.screens.pokedex.components.PokemonItem
import com.example.pokedex.presentation.screens.pokedex.mvi.PokemonEffect
import com.example.pokedex.presentation.screens.pokedex.mvi.PokemonUIEvent
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@Composable
fun PokemonListScreen(
    modifier: Modifier,
    viewModel: PokemonViewModel = koinViewModel(),
    navController: NavHostController
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        viewModel.onEvent(PokemonUIEvent.OnGetPokemonList)
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                is PokemonEffect.NavigateToPokemonDetail -> {

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
            items(state.pokemonList, key = { it.name }) { pokemon ->
                PokemonItem(
                    pokemon = pokemon,
                    onEvent = viewModel::onEvent
                )
            }
        }

        if (!state.errorMessage.isNullOrEmpty()) {
            Text(state.errorMessage ?: "")
        }
    }
}