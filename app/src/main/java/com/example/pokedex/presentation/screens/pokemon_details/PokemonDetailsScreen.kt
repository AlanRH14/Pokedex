package com.example.pokedex.presentation.screens.pokemon_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import org.koin.androidx.compose.koinViewModel

@Composable
fun PokemonDetailsScreen(
    modifier: Modifier = Modifier,
    pokemonName: String,
    viewModel: PokemonDetailViewModel = koinViewModel(),
    navController: NavHostController,
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {

    }
}