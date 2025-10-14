package com.example.pokedex.presentation.screens.pokemon_details

import com.example.pokedex.domain.models.PokemonDetail

data class PokemonDetailState(
    val isLoading: Boolean = true,
    val pokemonDetail: PokemonDetail? = null,
    val isFavorite: Boolean = false,
    val errorMessage: String? = null
)
