package com.example.pokedex.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.pokedex.presentation.screens.pokedex.PokedexScreen
import com.example.pokedex.presentation.screens.pokemon_details.PokemonDetailsScreen

@Composable
fun NavigationHost(
    modifier: Modifier,
    navController: NavHostController
) {

    NavHost(
        modifier = Modifier
            .fillMaxSize(),
        navController = navController,
        startDestination = NavRoute.PokemonsScreen
    ) {

        composable<NavRoute.PokemonsScreen> {
            PokedexScreen(
                modifier = modifier,
                navController = navController,
            )
        }

        composable<NavRoute.PokemonDetailScreen> {
            val pokemonName = it.toRoute<NavRoute.PokemonDetailScreen>().pokemonName
            PokemonDetailsScreen(
                pokemonName = pokemonName,
                navController = navController
            )
        }
    }
}