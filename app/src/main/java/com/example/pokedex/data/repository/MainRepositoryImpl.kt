package com.example.pokedex.data.repository

import androidx.compose.ui.res.painterResource
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.models.pokemon.PokemonResponse
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

    companion object {
        const val MAX_ITEMS_FOR_PAGE = 20
    }

    override fun fetchPokemonList(): Flow<PagingData<Pokemon>> {
        return Pager(
            config = PagingConfig(pageSize = MAX_ITEMS_FOR_PAGE),
            pagingSourceFactory = {
                PokemonMediator(
                    pokedexService = pokedexService,
                    pokemonMapper = pokemonMapper
                )
            }
        ).flow
    }
}