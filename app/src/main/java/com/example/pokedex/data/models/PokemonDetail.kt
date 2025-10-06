package com.example.pokedex.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonDetail(
    @SerialName("id") val id: Long = 0,
    @SerialName("name") val name: String? = null,
    val height: Long? = null,
    val weight: Long? = null,
    val sprites: Sprites? = null,
    val types: List<PokemonType>? = null,
    val stats: List<Stat>? = null,
    val abilities: List<Ability>? = null
)
