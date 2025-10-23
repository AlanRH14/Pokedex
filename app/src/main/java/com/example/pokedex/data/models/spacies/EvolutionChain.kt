package com.example.pokedex.data.models.spacies


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EvolutionChain(
    @SerialName("url")
    val url: String?
)