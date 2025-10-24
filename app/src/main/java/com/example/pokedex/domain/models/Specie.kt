package com.example.pokedex.domain.models

data class Specie(
    val id: Int = 0,
    val name: String = "",
    val baseHappiness: Int = 0,
    val captureRate: Int = 0,
    val idEvolutionChain: String = "",
    val description: String = "",
    val pokemonClass: String = "",
    val habitat: String = "",
    val isBaby: Boolean = false,
    val isLegendary: Boolean = false,
    val isMythical: Boolean = false,
)