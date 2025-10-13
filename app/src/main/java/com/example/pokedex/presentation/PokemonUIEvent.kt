package com.example.pokedex.presentation

sealed interface PokemonUIEvent {
    data object OnGetPokemonList : PokemonUIEvent
    data class OnClickPokemonDetail(val pokemonName: String) : PokemonUIEvent
}