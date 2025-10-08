package com.example.pokedex.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class Stat(
    val baseStat: Long? = null,
    val statName: String? = null
)
