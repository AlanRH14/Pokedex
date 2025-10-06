package com.example.pokedex.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Stat(
    @SerialName("base_stat") val baseStat: Long? = null,
    @SerialName("stat") val stat: StatInfo? = null
)
