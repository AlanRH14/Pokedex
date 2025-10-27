package com.example.pokedex.data.models.species

import com.example.pokedex.data.models.common.NameUrlBase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PalParkEncounter(
    @SerialName("area")
    val area: NameUrlBase?,
    @SerialName("base_score")
    val baseScore: Int?,
    @SerialName("rate")
    val rate: Int?
)