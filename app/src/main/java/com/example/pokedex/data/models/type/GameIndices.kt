package com.example.pokedex.data.models.type

import com.example.pokedex.data.models.type.common.NameUrlBase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameIndices(
    @SerialName("game_index")
    val gameIndex: Int?,
    @SerialName("generation")
    val generation: NameUrlBase?
)