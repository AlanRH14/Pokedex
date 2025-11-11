package com.example.pokedex.domain.models

data class PokemonType(
    val id: Int = 0,
    val name: String = "",
    val typeSlot: Int = 0,
    val namePokemon: String = "",
    val doubleDamageFrom: List<Type> = emptyList(),
    val doubleDamageTo: List<Type> = emptyList(),
    val halfDamageFrom: List<Type> = emptyList(),
    val halfDamageTo: List<Type> = emptyList(),
    val noDamageFrom: List<Type> = emptyList(),
    val noDamageTo: List<Type> = emptyList(),
)
