package com.example.pokedex.domain.models

data class PokemonDetail(
    val id: Long = 0,
    val name: String = "",
    val height: Long = 0,
    val weight: Long = 0,
    val sprites: Sprites = Sprites(),
    val types: List<String> = emptyList(),
    val stats: List<Stat> = emptyList(),
    val abilities: List<String> = emptyList()
)
