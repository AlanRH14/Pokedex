package com.example.pokedex.domain.models

data class Sprites(
    val frontDefault: String = "",
    val backDefault: String= "",
    val other: OtherSprites = OtherSprites()
)
