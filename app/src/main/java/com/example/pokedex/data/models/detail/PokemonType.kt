package com.example.pokedex.data.models.detail

import com.example.pokedex.data.models.detail.Type
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonType(
    @SerialName("slot") val slot: Int? = null,
    @SerialName("type") val type: Type? = null
)