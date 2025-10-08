package com.example.pokedex.data.models

data class PokemonResponse(
    val count: Long? = null,
    val next: String? = null,
    val previous: String? = null,
    val results: List<PokemonDto>? = null
)
