package com.example.pokedex.domain.models

data class Pokemon(
    val id: String = "",
    val name: String = "",
    val url: String = "",
    val colorPalette: Map<String, String> = emptyMap()
)
