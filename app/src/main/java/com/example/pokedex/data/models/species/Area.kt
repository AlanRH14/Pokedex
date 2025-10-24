package com.example.pokedex.data.models.species


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Area(
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?
)