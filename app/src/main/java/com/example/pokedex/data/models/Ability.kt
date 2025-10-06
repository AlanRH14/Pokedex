package com.example.pokedex.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Ability(
    val ability: AbilityInfo? = null
)
