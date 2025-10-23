package com.example.pokedex.data.models.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Type(
    @SerialName("name") val name: String? = null,
    @SerialName("url") val url: String? = null
)