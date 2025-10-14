package com.example.pokedex.presentation.screens.pokedex

sealed interface PokemonEffect {
    data class NavigateToPokemonDetail(val pokemonName: String): PokemonEffect
}