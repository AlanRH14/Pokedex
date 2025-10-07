package com.example.pokedex.domain.models

import com.example.pokedex.data.models.AbilityInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class Ability(
   val ability: AbilityInfo? = null
)
