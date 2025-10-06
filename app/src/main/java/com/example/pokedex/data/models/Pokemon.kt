package com.example.pokedex.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    @SerialName("id") val id: Long = 0,
    val name: String? = null,
    val url: String? = null
)
