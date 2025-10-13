package com.example.pokedex.data.repository

import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.models.PokemonDto
import com.example.pokedex.data.models.PokemonResponse
import com.example.pokedex.data.remote.PokedexService
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repository.MainRepository
import com.example.pokedex.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepositoryImpl(
    private val pokedexService: PokedexService,
    private val pokemonMapper: ApiMapper<PokemonResponse, List<Pokemon>>
) : MainRepository {

    override fun fetchPokemonList(): Flow<Resource<List<Pokemon>>> = flow {
        emit(Resource.Loading)
        try {
            val response = pokedexService.fetchPokemonList()
            emit(Resource.Success(data = pokemonMapper.mapperToDomain(dto = response)))
        } catch (e: Exception) {
            emit(Resource.Error(data = null, message = "Error: $e"))
        }
    }
}