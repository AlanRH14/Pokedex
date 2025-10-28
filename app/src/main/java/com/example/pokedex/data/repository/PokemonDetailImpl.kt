package com.example.pokedex.data.repository

import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.models.detail.PokemonDetailDto
import com.example.pokedex.data.models.species.SpeciesResponse
import com.example.pokedex.data.models.type.TypeDto
import com.example.pokedex.data.remote.PokedexService
import com.example.pokedex.domain.models.PokemonDetail
import com.example.pokedex.domain.models.PokemonType
import com.example.pokedex.domain.models.Species
import com.example.pokedex.domain.repository.PokemonDetailRepository
import com.example.pokedex.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokemonDetailImpl(
    private val pokedexService: PokedexService,
    private val pokemonDetailMapper: ApiMapper<PokemonDetailDto, PokemonDetail>,
    private val pokemonSpeciesMapper: ApiMapper<SpeciesResponse, Species>,
    private val pokemonTypeMapper: ApiMapper<TypeDto, PokemonType>,
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

    override fun fetchPokemonSpecies(species: String): Flow<Resource<Species>> = flow {
        emit(Resource.Loading)
        try {
            val response = pokedexService.fetchPokemonSpecies(species = species)
            emit(Resource.Success(data = pokemonSpeciesMapper.mapperToDomain(dto = response)))
        } catch (e: Exception) {
            emit(Resource.Error(data = null, message = "Error: $e"))
        }
    }

    override fun fetchPokemonType(type: String): Flow<Resource<PokemonType>> = flow {
        emit(Resource.Loading)
        try {
            val response = pokedexService.getType(type = type)
            emit(Resource.Success(data = pokemonTypeMapper.mapperToDomain(dto = response)))
        } catch (e: Exception) {
            emit(Resource.Error(data = null, message = "Error: $e"))
        }
    }
}