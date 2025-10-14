package com.example.pokedex.presentation

sealed interface PokemonEffect {
    data class NavigateToPokemonDetail(val pokemonName: String): PokemonEffect
}