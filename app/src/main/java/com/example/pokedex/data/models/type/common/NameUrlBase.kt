package com.example.pokedex.data.models.type.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NameUrlBase(
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?
)
