package com.example.pokedex.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Sprites(
    val frontDefault: String = "",
    val backDefault: String= "",
    val officialArtwork: String = ""
)
