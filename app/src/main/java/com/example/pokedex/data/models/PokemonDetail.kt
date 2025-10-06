package com.example.pokedex.data.models

data class PokemonDetail(
    val id: Long = 0,
    val name: String? = null,
    val height: Long? = null,
    val weight: Long? = null,
    val sprites: Sprites? = null,
    val types: List<PokemonType>? = null,
    val stats: List<Stat>? = null,
    val abilities: List<Ability>? = null
)
