package com.example.pokedex.data.models.type


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ScarletViolet(
    @SerialName("name_icon")
    val nameIcon: String?
)