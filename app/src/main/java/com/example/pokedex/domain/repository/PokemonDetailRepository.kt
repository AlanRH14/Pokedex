package com.example.pokedex.domain.repository

import com.example.pokedex.data.models.PokemonDetailDto
import com.example.pokedex.domain.models.PokemonDetail
import com.example.pokedex.utils.Resource
import kotlinx.coroutines.flow.Flow

interface PokemonDetailRepository {
    fun fetchPokemonDetail(name: String): Flow<Resource<PokemonDetail>>
}