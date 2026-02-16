package com.example.pokedex.domain.repository

import androidx.paging.PagingData
import com.example.pokedex.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun fetchPokemonList(): Flow<PagingData<Pokemon>>
}