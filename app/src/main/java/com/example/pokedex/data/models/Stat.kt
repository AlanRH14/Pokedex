package com.example.pokedex.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Stat(
    val baseStat: Long? = null,
    val stat: StatInfo? = null
)
