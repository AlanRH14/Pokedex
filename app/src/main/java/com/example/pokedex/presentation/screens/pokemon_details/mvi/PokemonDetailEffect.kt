package com.example.pokedex.presentation.screens.pokemon_details.mvi

sealed interface PokemonDetailEffect {
    data object NavigateToBack: PokemonDetailEffect
    data class NavigateToTabs(val route: String): PokemonDetailEffect
}