package com.example.pokedex.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.local.dao.PokemonsDao
import com.example.pokedex.data.local.entity.PokemonEntity
import com.example.pokedex.data.models.pokemon.PokemonResponse
import com.example.pokedex.data.remote.PokedexService

@OptIn(ExperimentalPagingApi::class)
class PokemonMediator(
    private val pokedexService: PokedexService,
    private val pokemonsDao: PokemonsDao,
    private val pokemonEntityMapper: ApiMapper<PokemonResponse, List<PokemonEntity>>,
) : RemoteMediator<Int, PokemonEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PokemonEntity>
    ): MediatorResult {
        return try {
            val offset = when (loadType) {
                LoadType.REFRESH -> 0
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        0
                    } else {
                        state.pages.sumOf { it.data.size }
                    }
                }
            }

            val response = pokedexService.fetchPokemonList(offset = offset, limit = state.config.pageSize)
            val entities = pokemonEntityMapper.mapperToDomain(dto = response)

            if (loadType == LoadType.REFRESH) {
                //pokemonsDao.insertPokemons(pokemons = entities)
            }

            pokemonsDao.insertPokemons(pokemons = entities)

            MediatorResult.Success(endOfPaginationReached = response.results.isNullOrEmpty())
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }
}