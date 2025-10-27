package com.example.pokedex.data.models.type


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationIii(
    @SerialName("colosseum")
    val colosseum: Colosseum?,
    @SerialName("emerald")
    val emerald: Emerald?,
    @SerialName("firered-leafgreen")
    val fireredLeafgreen: FireredLeafgreen?,
    @SerialName("ruby-saphire")
    val rubySaphire: RubySaphire?,
    @SerialName("xd")
    val xd: Xd?
)