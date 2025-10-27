package com.example.pokedex.data.models.type


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Name(
    @SerialName("language")
    val language: Language?,
    @SerialName("name")
    val name: String?
)