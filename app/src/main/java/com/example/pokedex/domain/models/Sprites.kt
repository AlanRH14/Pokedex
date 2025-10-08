package com.example.pokedex.domain.models

import com.example.pokedex.data.models.OtherSprites

data class Sprites(
    val frontDefault: String? = null,
    val backDefault: String? = null,
    val other: OtherSprites? = null
)
