package com.example.pokedex.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonResponse(
    @SerialName("count") val count: Long? = null,
    @SerialName("next") val next: String? = null,
    val previous: String? = null,
    val results: List<PokemonDto>? = null
)
