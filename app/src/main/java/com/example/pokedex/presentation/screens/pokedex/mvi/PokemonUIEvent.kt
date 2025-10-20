package com.example.pokedex.presentation.screens.pokedex.mvi

sealed interface PokemonUIEvent {
    data object OnGetPokemonList : PokemonUIEvent
    data class OnClickPokemonDetail(val pokemonName: String) : PokemonUIEvent
    data object OnPokemonItemVisible: PokemonUIEvent
}