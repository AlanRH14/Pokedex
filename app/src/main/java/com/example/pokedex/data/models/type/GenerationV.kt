package com.example.pokedex.data.models.type


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationV(
    @SerialName("black-2-white-2")
    val black2White2: Black2White2?,
    @SerialName("black-white")
    val blackWhite: Black2White2?
)