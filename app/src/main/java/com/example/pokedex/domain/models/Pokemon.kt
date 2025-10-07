package com.example.pokedex.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class Pokemon(
    val id: Long = 0,
    val name: String? = null,
    val url: String? = null
)
