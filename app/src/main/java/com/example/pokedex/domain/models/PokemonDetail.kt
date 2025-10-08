package com.example.pokedex.domain.models

import com.example.pokedex.data.models.Ability
import com.example.pokedex.data.models.PokemonType
import com.example.pokedex.data.models.Sprites
import com.example.pokedex.data.models.Stat
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class PokemonDetail(
    val id: Long = 0,
    val name: String = "",
    val height: Long = 0,
    val weight: Long = 0,
    val sprites: Sprites = Sprites(),
    val types: List<PokemonType> = emptyList(),
    val stats: List<Stat>? = null,
    val abilities: List<Ability>? = null
)
