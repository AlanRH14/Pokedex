package com.example.pokedex.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationHost(
    modifier: Modifier,
    navController: NavHostController
) {

    NavHost(
        modifier = modifier
            .fillMaxSize(),
        navController = navController,
        startDestination = NavRoute.PokemonsScreen
    ) {

        composable<NavRoute.PokemonsScreen> {

        }
    }
}