package com.example.pokedex.domain.models

import com.example.pokedex.data.models.Ability
import com.example.pokedex.data.models.PokemonType
import com.example.pokedex.data.models.Sprites
import com.example.pokedex.data.models.Stat
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
