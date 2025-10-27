package com.example.pokedex.data.models.type

import com.example.pokedex.data.models.type.common.NameIconBase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationViii(
    @SerialName("brilliant-diamond-and-shining-pearl")
    val brilliantDiamondAndShiningPearl: NameIconBase?,
    @SerialName("legends-arceus")
    val legendsArceus: NameIconBase?,
    @SerialName("sword-shield")
    val swordShield: NameIconBase?
)