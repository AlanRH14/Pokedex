package com.example.pokedex.data.models.type


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Damage(
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?
)