package com.example.pokedex.data.models.species


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FormDescription(
    @SerialName("description")
    val description: String?,
    @SerialName("language")
    val language: LanguageX?
)