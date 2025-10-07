package com.example.pokedex.data.remote

import com.example.pokedex.data.models.PokemonDetailDto
import com.example.pokedex.data.models.PokemonDto
import com.example.pokedex.data.models.PokemonType
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0,
    ): List<PokemonDto>

    @GET("pokemon/{name}")
    suspend fun fetchPokemonInfo(
        @Path("name") name: String
    ): PokemonDetailDto
}