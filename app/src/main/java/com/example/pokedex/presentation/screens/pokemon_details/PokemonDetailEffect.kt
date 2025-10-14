package com.example.pokedex.presentation.screens.pokemon_details

sealed interface PokemonDetailEffect {
    data object NavigateToBack: PokemonDetailEffect
}