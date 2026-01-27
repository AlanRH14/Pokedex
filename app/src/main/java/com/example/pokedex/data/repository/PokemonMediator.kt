package com.example.pokedex.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.models.pokemon.PokemonDto
import com.example.pokedex.data.models.pokemon.PokemonResponse
import com.example.pokedex.data.remote.PokedexService
import com.example.pokedex.domain.models.Pokemon

class PokemonMediator(
    private val pokedexService: PokedexService,
    private val pokemonMapper: ApiMapper<PokemonResponse, List<Pokemon>>
) : PagingSource<Int, Pokemon>() {

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(state.config.pageSize)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(state.config.pageSize)
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
            val response = pokedexService.fetchPokemonList(limit = params.loadSize, offset = page)
            val prevKey = if (page == 0) null else  page - params.loadSize
            val nextPageNumber = if (response.next != null) page + params.loadSize else null

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