package com.example.pokedex.data.models.type


import com.example.pokedex.data.models.type.common.NameIconBase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationIv(
    @SerialName("diamond-pearl")
    val diamondPearl: DiamondPearl?,
    @SerialName("heartgold-soulsilver")
    val heartgoldSoulsilver: HeartgoldSoulsilver?,
    @SerialName("platinum")
    val platinum: NameIconBase?
)