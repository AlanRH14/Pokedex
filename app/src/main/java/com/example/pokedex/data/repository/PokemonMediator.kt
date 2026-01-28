package com.example.pokedex.data.repository

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.models.pokemon.PokemonDto
import com.example.pokedex.data.models.pokemon.PokemonResponse
import com.example.pokedex.data.remote.PokedexService
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.utils.Constants.PAGING_MAX_SIZE

class PokemonMediator(
    private val pokedexService: PokedexService,
    private val pokemonMapper: ApiMapper<PokemonResponse, List<Pokemon>>
) : PagingSource<Int, Pokemon>() {

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        return try {
            when (params) {
                is LoadParams.Refresh -> {}

                is LoadParams.Prepend -> {}

                is LoadParams.Append -> {}
            }

            val page = params.key ?: 0
            val response = pokedexService.fetchPokemonList( offset = page, limit = params.loadSize)
            val prevKey = if (page == 0) null else page - params.loadSize
            val nextPageNumber = if (!response.results.isNullOrEmpty()) page + params.loadSize else null

            Log.d("PokemonMediator", "loadSize: ${params.loadSize}")
            Log.d("PokemonMediator", "page: $page")
            Log.d("PokemonMediator", "response: $response")
            Log.d("PokemonMediator", "prevKey: $prevKey")
            Log.d("PokemonMediator", "nextPageNumber: $prevKey")

            LoadResult.Page(
                data = pokemonMapper.mapperToDomain(dto = response),
                prevKey = prevKey,
                nextKey = nextPageNumber,
            )
        } catch (e: Exception) {
            LoadResult.Error(throwable = e)
        }
    }
}