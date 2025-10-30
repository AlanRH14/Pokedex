package com.example.pokedex.data.models.type

import com.example.pokedex.data.models.type.common.NameIconBase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationViii(
    @SerialName("brilliant-diamond-and-shining-pearl")
    val brilliantDiamondAndShiningPearl: NameIconBase? = null,
    @SerialName("legends-arceus")
    val legendsArceus: NameIconBase? = null,
    @SerialName("sword-shield")
    val swordShield: NameIconBase? = null
)