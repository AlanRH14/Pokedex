package com.example.pokedex.data.models.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonDto(
    @SerialName("name") val name: String? = null,
    @SerialName("url") val url: String? = null,
)