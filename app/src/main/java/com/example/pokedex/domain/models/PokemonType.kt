package com.example.pokedex.domain.models

data class PokemonType(
    val id: Int = 0,
    val name: String = "",
    val typeSlot: Int = 0,
    val namePokemon: String = "",
    val doubleDamageFrom: List<String> = emptyList(),
    val doubleDamageTo: List<String> = emptyList(),
    val halfDamageFrom: List<String> = emptyList(),
    val halfDamageTo: List<String> = emptyList(),
    val noDamageFrom: List<String> = emptyList(),
    val noDamageTo: List<String> = emptyList(),
)
