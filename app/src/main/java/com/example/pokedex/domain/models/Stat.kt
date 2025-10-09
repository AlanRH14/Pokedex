package com.example.pokedex.domain.models

import kotlinx.serialization.Serializer

@Serializer
data class Stat(
    val baseStat: Long = 0,
    val stat: String = ""
)
