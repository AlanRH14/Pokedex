package com.example.pokedex.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel

@Composable
fun PokemonListScreen(
    modifier: Modifier,
    viewModel: PokemonViewModel = koinViewModel()
) {

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {

    }
}