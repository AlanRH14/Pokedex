package com.example.pokedex.presentation.screens.pokemon_details

sealed interface PokemonDetailUIEvent {
    data class GetPokemonDetail(val pokemonName: String): PokemonDetailUIEvent
}