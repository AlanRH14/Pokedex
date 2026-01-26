package com.example.pokedex.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pokedex.data.models.pokemon.PokemonDto
import com.example.pokedex.data.remote.PokedexService
import com.example.pokedex.domain.models.Pokemon

/*class PokemonMediator(
    private val pokedexService: PokedexService,
) : PagingSource<Int, PokemonDto>() {

    override fun getRefreshKey(state: PagingState<Int, PokemonDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition = anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition = anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonDto> {
        try {
            when (params) {
                is LoadParams.Refresh -> {}

                is LoadParams.Prepend -> {}

                is LoadParams.Append -> {}
            }

            val nextPageNumber = params.key ?: 1
            val response = pokedexService.fetchPokemonList(offset = nextPageNumber)

            return LoadResult.Page(
                data = response?.results ?: emptyList(),
                prevKey = response.previous ?: "",
                nextKey = response.next ?: ""
            )

        } catch (e: Exception) {
            return LoadResult.Error(throwable = e)
        }
    }
}*/