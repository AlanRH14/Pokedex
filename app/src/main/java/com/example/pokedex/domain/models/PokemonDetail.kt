package com.example.pokedex.domain.models

data class PokemonDetail(
    val id: String = "",
    val name: String = "",
    val url: String = "",
    val height: Float = 0F,
    val weight: Float = 0F,
    val sprites: Sprites = Sprites(),
    val types: List<Type> = emptyList(),
    val stats: List<Stat> = emptyList(),
    val abilities: List<String> = emptyList()
)
