package com.example.pokedex.data.models.type

import com.example.pokedex.data.models.type.common.NameUrlBase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    @SerialName("pokemon")
    val pokemon: NameUrlBase?,
    @SerialName("slot")
    val slot: Int?
)