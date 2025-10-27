package com.example.pokedex.data.models.species


import com.example.pokedex.data.models.type.common.NameUrlBase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FlavorTextEntry(
    @SerialName("flavor_text")
    val flavorText: String?,
    @SerialName("language")
    val language: NameUrlBase?,
    @SerialName("version")
    val version: Version?
)