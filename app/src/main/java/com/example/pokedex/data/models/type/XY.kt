package com.example.pokedex.data.models.type


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class XY(
    @SerialName("name_icon")
    val nameIcon: String?
)