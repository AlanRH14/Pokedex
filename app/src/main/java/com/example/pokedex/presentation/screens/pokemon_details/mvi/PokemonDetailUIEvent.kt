package com.example.pokedex.presentation.screens.pokemon_details.mvi

import com.example.pokedex.navigation.TabsNavRoute

sealed interface PokemonDetailUIEvent {
    data class OnGetPokemonDetail(val pokemonName: String): PokemonDetailUIEvent
    data class OnGetPokemonSpecies(val species: String): PokemonDetailUIEvent
    data class OnGetPokemonType(val pokemonID: String): PokemonDetailUIEvent
    data object OnClickedToggleFavorite: PokemonDetailUIEvent
    data object OnClickedBack: PokemonDetailUIEvent
    data class OnClickTabNavigation(val route: TabsNavRoute): PokemonDetailUIEvent
}