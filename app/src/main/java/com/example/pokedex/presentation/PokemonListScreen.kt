package com.example.pokedex.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@Composable
fun PokemonListScreen(
    modifier: Modifier,
    viewModel: PokemonViewModel = koinViewModel(),
    navController: NavHostController
) {

    val state = viewModel.state.collectAsStateWithLifecycle()

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

    }
}