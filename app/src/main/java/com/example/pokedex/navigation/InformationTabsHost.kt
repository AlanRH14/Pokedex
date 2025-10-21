package com.example.pokedex.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pokedex.domain.models.PokemonDetail
import com.example.pokedex.navigation.TabsNavRoute.*
import com.example.pokedex.presentation.screens.pokemon_details.widgets.PokemonStats

@Composable
fun InformationTabsHost(
    navController: NavHostController,
    pokemonDetail: PokemonDetail? = null
) {
    NavHost(
        modifier = Modifier.fillMaxSize(),
        startDestination = About,
        navController = navController,
    ) {
        composable<About> {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Information")
            }
        }

        composable<Stats> {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                PokemonStats(stats = pokemonDetail?.stats ?: emptyList())
            }
        }

        composable<Defence> {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Defence")
            }
        }

        composable<Evolution> {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Evolution")
            }
        }
    }
}