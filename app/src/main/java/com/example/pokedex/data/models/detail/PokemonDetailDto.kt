package com.example.pokedex.data.models.detail

import com.example.pokedex.data.models.detail.Ability
import com.example.pokedex.data.models.detail.PokemonType
import com.example.pokedex.data.models.Sprites
import com.example.pokedex.data.models.detail.Stat
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonDetailDto(
    @SerialName("id") val id: Long = 0,
    @SerialName("name") val name: String? = null,
    @SerialName("height") val height: Long? = null,
    @SerialName("weight") val weight: Long? = null,
    @SerialName("base_experience") val experience: Long? = null,
    @SerialName("sprites") val sprites: Sprites? = null,
    @SerialName("types") val types: List<PokemonType>? = null,
    @SerialName("stats") val stats: List<Stat>? = null,
    @SerialName("abilities") val abilities: List<Ability>? = null
)