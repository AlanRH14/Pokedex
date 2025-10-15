package com.example.pokedex.domain.models

data class PokemonDetail(
    val id: String = "",
    val name: String = "",
    val url: String = "",
    val height: Long = 0,
    val weight: Long = 0,
    val sprites: Sprites = Sprites(),
    val types: List<Type> = emptyList(),
    val stats: List<Stat> = emptyList(),
    val abilities: List<String> = emptyList()
)
