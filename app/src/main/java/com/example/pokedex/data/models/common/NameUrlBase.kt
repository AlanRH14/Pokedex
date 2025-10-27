package com.example.pokedex.data.models.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NameUrlBase(
    @SerialName("name")
    val name: String? = null,

    @SerialName("url")
    val url: String? = null,
)
