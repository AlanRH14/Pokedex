package com.example.pokedex.presentation

sealed interface PokemonEffect {
    data object NavigateToPokemonDetail: PokemonEffect
}