package com.example.pokedex.presentation.pokedex

sealed interface PokemonEffect {
    data class NavigateToPokemonDetail(val pokemonName: String): PokemonEffect
}