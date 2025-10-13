package com.example.pokedex.data.repository

import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.models.PokemonDetailDto
import com.example.pokedex.data.remote.PokedexService
import com.example.pokedex.domain.models.PokemonDetail
import com.example.pokedex.domain.repository.PokemonDetailRepository
import com.example.pokedex.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokemonDetailImpl(
    private val pokedexService: PokedexService,
    private val pokemonDetailMapper: ApiMapper<PokemonDetailDto, PokemonDetail>
) : PokemonDetailRepository {

    override fun fetchPokemonDetail(name: String): Flow<Resource<PokemonDetail>> = flow {
        emit(Resource.Loading)
        try {
            val response = pokedexService.fetchPokemonInfo(name = name)
            emit(Resource.Success(data = pokemonDetailMapper.mapperToDomain(response)))
        } catch (e: Exception) {
            emit(Resource.Error(data = null, message = "Error: $e"))
        }
    }
}