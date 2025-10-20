package com.example.pokedex.presentation.screens.pokedex.mvi

import com.example.pokedex.domain.models.Pokemon

sealed interface PokemonUIEvent {
    data object OnGetPokemonList : PokemonUIEvent
    data class OnClickPokemonDetail(val pokemonName: String) : PokemonUIEvent
    data class OnPokemonItemVisible(val pokemon: Pokemon): PokemonUIEvent
}