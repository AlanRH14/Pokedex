package com.example.pokedex.domain.repository

import com.example.pokedex.data.models.PokemonDto
import com.example.pokedex.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun fetchPokemonList(): Flow<Resource<List<PokemonDto>>>
}