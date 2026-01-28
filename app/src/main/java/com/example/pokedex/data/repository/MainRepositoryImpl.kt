package com.example.pokedex.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.models.pokemon.PokemonResponse
import com.example.pokedex.data.remote.PokedexService
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class MainRepositoryImpl(
    private val pokedexService: PokedexService,
    private val pokemonMapper: ApiMapper<PokemonResponse, List<Pokemon>>
) : MainRepository {

    override fun fetchPokemonList(): Flow<PagingData<Pokemon>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20,
                prefetchDistance = 2,
                enablePlaceholders = true
            ),
            pagingSourceFactory = {
                PokemonMediator(
                    pokedexService = pokedexService,
                    pokemonMapper = pokemonMapper
                )
            }
        ).flow
    }
}