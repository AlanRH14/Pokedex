package com.example.pokedex.data.models.type.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NameIconBase(
    @SerialName("name_icon")
    val nameIcon: String?
)
