package com.example.pokedex.data.models.detail

import com.example.pokedex.data.models.detail.AbilityInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Ability(
    @SerialName("ability") val ability: AbilityInfo? = null
)