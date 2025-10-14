package com.example.pokedex.presentation.screens.pokemon_details

import com.example.pokedex.domain.repository.PokemonDetailRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PokemonDetailViewModel(
    private val pokemonDetail: PokemonDetailRepository
) {

    private val _state = MutableStateFlow(PokemonDetailState())
    val state = _state.asStateFlow()
}