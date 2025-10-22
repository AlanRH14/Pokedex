package com.example.pokedex.data.models.detail

import com.example.pokedex.data.models.StatInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Stat(
    @SerialName("base_stat") val baseStat: Int? = null,
    @SerialName("stat") val stat: StatInfo? = null
)