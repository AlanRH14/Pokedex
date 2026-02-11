package com.example.pokedex.data.repository

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.local.dao.PokemonsDao
import com.example.pokedex.data.local.entity.PokemonEntity
import com.example.pokedex.data.models.pokemon.PokemonResponse
import com.example.pokedex.data.remote.PokedexService
import com.example.pokedex.domain.models.Pokemon

class PokemonMediator(
    private val pokedexService: PokedexService,
    private val pokemonsDao: PokemonsDao,
    private val pokemonEntityMapper: ApiMapper<PokemonResponse, List<PokemonEntity>>,
    private val pokemonMapper: ApiMapper<List<PokemonEntity>, List<Pokemon>>,
) : PagingSource<Int, Pokemon>() {

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition = anchorPosition)
            anchorPage?.prevKey?.plus(state.config.pageSize)
                ?: anchorPage?.nextKey?.minus(state.config.pageSize)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        return try {
            when (params) {
                is LoadParams.Refresh -> {}

                is LoadParams.Prepend -> {}

                is LoadParams.Append -> {}
            }

            val page = params.key ?: 0
            val response = pokedexService.fetchPokemonList(offset = page, limit = params.loadSize)
            val pokemonEntity = pokemonEntityMapper.mapperToDomain(dto = response)
            pokemonsDao.insertPokemons(pokemons = pokemonEntity)
            LoadResult.Page(
                data = pokemonMapper.mapperToDomain(dto = pokemonEntity),
                prevKey = if (page == 0) null else page - params.loadSize,
                nextKey = if (!response.results.isNullOrEmpty()) page + params.loadSize else null,
            )
        } catch (e: Exception) {
            Log.d("LordMiau", "Exception: ${e.message}")
            LoadResult.Error(throwable = e)
        }
    }
}