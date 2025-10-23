package com.example.pokedex.data.models.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StatInfo(
    @SerialName("name") val name: String? = null
)