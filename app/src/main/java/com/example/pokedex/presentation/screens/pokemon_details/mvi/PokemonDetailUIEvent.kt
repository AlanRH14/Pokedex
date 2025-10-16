package com.example.pokedex.presentation.screens.pokemon_details.mvi

sealed interface PokemonDetailUIEvent {
    data class OnGetPokemonDetail(val pokemonName: String): PokemonDetailUIEvent
    data object OnClickedToggleFavorite: PokemonDetailUIEvent
    data object OnClickedBack: PokemonDetailUIEvent
}