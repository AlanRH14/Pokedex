package com.example.pokedex.domain.models

import com.example.pokedex.data.models.Ability
import com.example.pokedex.data.models.Sprites
import com.example.pokedex.data.models.Stat

data class PokemonDetail(
    val id: Long = 0,
    val name: String = "",
    val height: Long = 0,
    val weight: Long = 0,
    val sprites: Sprites = Sprites(),
    val types: List<PokemonType> = emptyList(),
    val stats: List<Stat> = emptyList(),
    val abilities: List<Ability> = emptyList()
)
