package com.example.pokedex.data.models.species


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FlavorTextEntry(
    @SerialName("flavor_text")
    val flavorText: String?,
    @SerialName("language")
    val language: Language?,
    @SerialName("version")
    val version: Version?
)