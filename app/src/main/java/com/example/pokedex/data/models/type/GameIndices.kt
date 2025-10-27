package com.example.pokedex.data.models.type


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameIndices(
    @SerialName("game_index")
    val gameIndex: Int?,
    @SerialName("generation")
    val generation: GenerationX?
)