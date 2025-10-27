package com.example.pokedex.data.models.species

import com.example.pokedex.data.models.type.common.NameUrlBase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FormDescription(
    @SerialName("description")
    val description: String?,
    @SerialName("language")
    val language: NameUrlBase?
)