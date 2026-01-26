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
            state.closestPageToPosition(anchorPosition = anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition = anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        try {
            when (params) {
                is LoadParams.Refresh -> {}

                is LoadParams.Prepend -> {}

                is LoadParams.Append -> {}
            }

            val page = params.key ?: 1
            val response = pokedexService.fetchPokemonList(offset = page)
            val prevKey = if (page > 0) 0 else null
            val nextPageNumber = if (response.next != null) page + 1 else null

            return LoadResult.Page(
                data = pokemonMapper.mapperToDomain(dto = response),
                prevKey = prevKey,
                nextKey = nextPageNumber,
            )
        } catch (e: Exception) {
            return LoadResult.Error(throwable = e)
        }
    }
}