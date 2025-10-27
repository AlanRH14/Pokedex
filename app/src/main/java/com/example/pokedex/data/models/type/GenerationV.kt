package com.example.pokedex.data.models.type


import com.example.pokedex.data.models.type.common.NameIconBase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationV(
    @SerialName("black-2-white-2")
    val black2White2: NameIconBase?,
    @SerialName("black-white")
    val blackWhite: NameIconBase?
)