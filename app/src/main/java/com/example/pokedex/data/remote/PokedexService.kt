package com.example.pokedex.data.remote

import com.example.pokedex.data.models.PokemonDetailDto
import com.example.pokedex.data.models.PokemonDto
import com.example.pokedex.utils.Constants.NAME_PATH
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokedexService {

    @GET("pokemon")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0,
    ): List<PokemonDto>

    @GET("pokemon/{name}")
    suspend fun fetchPokemonInfo(
        @Path(NAME_PATH) name: String
    ): PokemonDetailDto
}