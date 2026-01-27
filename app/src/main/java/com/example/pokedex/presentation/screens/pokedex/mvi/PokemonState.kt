package com.example.pokedex.presentation.screens.pokedex.mvi

import androidx.paging.PagingData
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonPaletteColors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class PokemonState(
    val isLoading : Boolean = true,
    val pokemonList: Flow<PagingData<Pokemon>> = emptyFlow(),
    val pokemonPalettes: Map<String, PokemonPaletteColors> = emptyMap(),
    val errorMessage: String? = null,
)