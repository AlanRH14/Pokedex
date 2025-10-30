package com.example.pokedex.data.models.type

import com.example.pokedex.data.models.type.common.NameIconBase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationIii(
    @SerialName("colosseum")
    val colosseum: NameIconBase? = null,
    @SerialName("emerald")
    val emerald: NameIconBase? = null,
    @SerialName("firered-leafgreen")
    val fireredLeafgreen: NameIconBase? = null,
    @SerialName("ruby-saphire")
    val rubySaphire: NameIconBase? = null,
    @SerialName("xd")
    val xd: NameIconBase? = null
)