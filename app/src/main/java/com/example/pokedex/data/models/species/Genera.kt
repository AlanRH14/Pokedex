package com.example.pokedex.data.models.species

import com.example.pokedex.data.models.common.NameUrlBase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Genera(
    @SerialName("genus")
    val genus: String?,
    @SerialName("language")
    val language: NameUrlBase?
)