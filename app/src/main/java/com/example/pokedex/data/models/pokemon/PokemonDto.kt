package com.example.pokedex.data.models.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonDto(
    @SerialName("id") val id: Long = 0,
    @SerialName("name") val name: String? = null,
)