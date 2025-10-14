package com.example.pokedex.presentation.screens.pokemon_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@Composable
fun PokemonDetailsScreen(
    modifier: Modifier = Modifier,
    pokemonName: String,
    viewModel: PokemonDetailViewModel = koinViewModel(),
    navController: NavHostController,
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = pokemonName) {
        viewModel.onEvent(PokemonDetailUIEvent.GetPokemonDetail(pokemonName = pokemonName))
    }

    LaunchedEffect(key1 = true) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                is PokemonDetailEffect.NavigateToBack -> navController.popBackStack()
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {

    }
}