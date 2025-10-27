package com.example.pokedex.data.models.type


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationIx(
    @SerialName("scarlet-violet")
    val scarletViolet: ScarletViolet?
)