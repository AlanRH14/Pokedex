package com.example.pokedex.data.models.type


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    @SerialName("pokemon")
    val pokemon: PokemonX?,
    @SerialName("slot")
    val slot: Int?
)