package com.example.pokedex.data.models.type


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NoDamageTo(
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?
)