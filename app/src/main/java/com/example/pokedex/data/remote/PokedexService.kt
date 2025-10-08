package com.example.pokedex.data.remote

import com.example.pokedex.data.models.PokemonDetailDto
import com.example.pokedex.data.models.PokemonResponse
import com.example.pokedex.utils.Constants.LIMIT_QUERY
import com.example.pokedex.utils.Constants.NAME_PATH
import com.example.pokedex.utils.Constants.OFFSET_QUERY
import com.example.pokedex.utils.Constants.PAGING_SIZE
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokedexService {

    @GET("pokemon")
    suspend fun fetchPokemonList(
        @Query(LIMIT_QUERY) limit: Int = PAGING_SIZE,
        @Query(OFFSET_QUERY) offset: Int = 0,
    ): PokemonResponse

    @GET("pokemon/{name}")
    suspend fun fetchPokemonInfo(
        @Path(NAME_PATH) name: String
    ): PokemonDetailDto
}