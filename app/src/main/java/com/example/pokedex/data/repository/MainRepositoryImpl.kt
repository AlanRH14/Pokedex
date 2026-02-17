package com.example.pokedex.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.local.dao.PokemonsDao
import com.example.pokedex.data.local.entity.PokemonEntity
import com.example.pokedex.data.models.pokemon.PokemonResponse
import com.example.pokedex.data.remote.PokedexService
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repository.MainRepository
import com.example.pokedex.utils.Constants.PAGING_MAX_SIZE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@ExperimentalPagingApi
class MainRepositoryImpl(
    private val pokedexService: PokedexService,
    private val pokemonsDao: PokemonsDao,
    private val pokemonEntityMapper: ApiMapper<PokemonResponse, List<PokemonEntity>>,
    private val pokemonMapper: ApiMapper<PokemonEntity, Pokemon>
) : MainRepository {

    override fun fetchPokemonList(): Flow<PagingData<Pokemon>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGING_MAX_SIZE,
                initialLoadSize = PAGING_MAX_SIZE,
                prefetchDistance = 5,
                enablePlaceholders = false
            ),
            remoteMediator = PokemonMediator(
                pokedexService = pokedexService,
                pokemonsDao = pokemonsDao,
                pokemonEntityMapper = pokemonEntityMapper,
            ),
            pagingSourceFactory = {
                pokemonsDao.getAllPokemons()
            }
        ).flow.map { pagingData ->
            pagingData.map { entity ->
                pokemonMapper.mapperToDomain(entity)
            }
        }
    }
}