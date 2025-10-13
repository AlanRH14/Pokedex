package com.example.pokedex.domain.repository

import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun fetchPokemonList(): Flow<Resource<List<Pokemon>>>
}