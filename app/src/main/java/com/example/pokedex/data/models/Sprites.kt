package com.example.pokedex.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Sprites(
    @SerialName("front_default") val frontDefault: String? = null,
    val backDefault: String? = null,
    val other: OtherSprits? = null
)
