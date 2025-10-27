package com.example.pokedex.domain.models

data class PokemonType(
    val id: Int = 0,
    val name: String = "",
    val typeSlot: Int = 0,
    val namePokemon: String = "",
    val doubleDamageFrom: List<String> = emptyList(),
    val doubleDamage: List<String> = emptyList(),
    val doubleDamageTo: List<String>,
    val halfDamageFrom: List<String>,
    val halfDamageTo: List<String>,
    val noDamageFrom: List<String>,
    val noDamageTo: List<String>
)
