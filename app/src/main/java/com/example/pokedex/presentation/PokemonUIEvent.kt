package com.example.pokedex.presentation

sealed interface PokemonUIEvent {
    data object OnGetPokemonList: PokemonUIEvent
}