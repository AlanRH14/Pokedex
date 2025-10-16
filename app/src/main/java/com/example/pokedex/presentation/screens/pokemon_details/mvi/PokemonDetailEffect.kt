package com.example.pokedex.presentation.screens.pokemon_details.mvi

sealed interface PokemonDetailEffect {
    data object NavigateToBack: PokemonDetailEffect
}