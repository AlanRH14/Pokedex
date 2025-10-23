package com.example.pokedex.data.models.detail

import com.example.pokedex.data.models.detail.OtherSprites
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Sprites(
    @SerialName("front_default") val frontDefault: String? = null,
    @SerialName("back_default") val backDefault: String? = null,
    @SerialName("other") val other: OtherSprites? = null
)