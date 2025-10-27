package com.example.pokedex.data.models.species

import com.example.pokedex.data.models.type.common.NameUrlBase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Variety(
    @SerialName("is_default")
    val isDefault: Boolean?,
    @SerialName("pokemon")
    val pokemon: NameUrlBase?
)