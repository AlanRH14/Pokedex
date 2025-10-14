package com.example.pokedex.presentation.screens.pokedex

sealed interface PokemonUIEvent {
    data object OnGetPokemonList : PokemonUIEvent
    data class OnClickPokemonDetail(val pokemonName: String) : PokemonUIEvent
}