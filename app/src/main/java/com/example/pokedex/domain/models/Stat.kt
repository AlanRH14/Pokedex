package com.example.pokedex.domain.models

import com.example.pokedex.data.models.StatInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class Stat(
    val baseStat: Long? = null, val stat: StatInfo? = null
)
