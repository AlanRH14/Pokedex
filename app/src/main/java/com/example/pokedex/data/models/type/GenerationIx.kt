package com.example.pokedex.data.models.type

import com.example.pokedex.data.models.type.common.NameIconBase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationIx(
    @SerialName("scarlet-violet")
    val scarletViolet: NameIconBase? = null
)