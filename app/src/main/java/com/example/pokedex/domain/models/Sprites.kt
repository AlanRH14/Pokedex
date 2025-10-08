package com.example.pokedex.domain.models

import com.example.pokedex.data.models.OtherSprites

data class Sprites(
    val frontDefault: String = "",
    val backDefault: String= "",
    val other: OtherSprites = OtherSprites()
)
