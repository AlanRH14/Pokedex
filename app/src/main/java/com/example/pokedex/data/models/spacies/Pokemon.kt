package com.example.pokedex.data.models.spacies


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?
)