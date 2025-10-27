package com.example.pokedex.data.models.type


import com.example.pokedex.data.models.type.common.NameIconBase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationIii(
    @SerialName("colosseum")
    val colosseum: NameIconBase?,
    @SerialName("emerald")
    val emerald: NameIconBase?,
    @SerialName("firered-leafgreen")
    val fireredLeafgreen: NameIconBase?,
    @SerialName("ruby-saphire")
    val rubySaphire: NameIconBase?,
    @SerialName("xd")
    val xd: NameIconBase?
)