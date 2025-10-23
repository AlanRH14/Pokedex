package com.example.pokedex.data.models.spacies


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Genera(
    @SerialName("genus")
    val genus: String?,
    @SerialName("language")
    val language: Language?
)