package com.example.pokedex.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Sprites(
    val frontDefault: String? = null,
    val backDefault: String? = null,
    val other: OtherSprits? = null
)
