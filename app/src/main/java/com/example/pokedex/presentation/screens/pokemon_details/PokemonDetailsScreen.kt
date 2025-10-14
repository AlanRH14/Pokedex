package com.example.pokedex.presentation.screens.pokemon_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.pokedex.domain.models.PokemonDetail

@Composable
fun PokemonDetailsScreen(
    modifier: Modifier = Modifier,
    pokemonName: String,
    navController: NavHostController,
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {

    }
}