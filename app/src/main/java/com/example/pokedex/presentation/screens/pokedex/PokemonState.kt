package com.example.pokedex.presentation.screens.pokedex

import com.example.pokedex.domain.models.Pokemon

data class PokemonState(
    val isLoading : Boolean = true,
    val pokemonList: List<Pokemon> = emptyList(),
    val errorMessage: String? = null
)