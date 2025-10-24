package com.example.pokedex.data.models.species


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PalParkEncounter(
    @SerialName("area")
    val area: Area?,
    @SerialName("base_score")
    val baseScore: Int?,
    @SerialName("rate")
    val rate: Int?
)