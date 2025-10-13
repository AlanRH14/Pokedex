package com.example.pokedex.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun PokemonListScreen(
    modifier: Modifier,
    viewModel: PokemonViewModel = koinViewModel()
) {

    val state = viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true) {
        viewModel.onEvent(PokemonUIEvent.OnGetPokemonList)

    }

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {

    }
}