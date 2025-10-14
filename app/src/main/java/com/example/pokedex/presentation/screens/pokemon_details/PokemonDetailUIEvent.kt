package com.example.pokedex.presentation.screens.pokemon_details

sealed interface PokemonDetailUIEvent {
    data class OnGetPokemonDetail(val pokemonName: String): PokemonDetailUIEvent
    data object OnClickedToggleFavorite: PokemonDetailUIEvent
}


}