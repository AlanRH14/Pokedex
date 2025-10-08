package com.example.pokedex.domain.repository

import com.example.pokedex.data.models.PokemonDto
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun fetchPokemonList(): Flow<List<PokemonDto>>
}