package com.example.pokedex.data.models.specie


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Habitat(
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?
)