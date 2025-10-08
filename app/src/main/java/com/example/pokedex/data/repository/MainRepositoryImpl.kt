package com.example.pokedex.data.repository

import com.example.pokedex.data.models.PokemonDto
import com.example.pokedex.data.remote.PokedexService
import com.example.pokedex.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepositoryImpl(
    private val pokedexService: PokedexService
) : MainRepository {

    override fun fetchPokemonList(): Flow<List<PokemonDto>> = flow {
        try {
            val response = pokedexService.fetchPokemonList()
        } catch (e: Exception) {

        }
    }
}