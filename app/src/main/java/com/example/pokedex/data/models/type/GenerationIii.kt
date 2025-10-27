package com.example.pokedex.data.models.type


import com.example.pokedex.data.models.type.common.NameIconBase
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
    val rubySaphire: NameIconBase?,
    @SerialName("xd")
    val xd: NameIconBase?
)