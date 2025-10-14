package com.example.pokedex.presentation.screens.pokedex.mvi

sealed interface PokemonEffect {
    data class NavigateToPokemonDetail(val pokemonName: String): PokemonEffect
}