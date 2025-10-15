package com.example.pokedex.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Stat(
    val baseStat: Int = 0,
    val stat: String = ""
) {
    val maxValue: Int
        get() = when (stat) {
            "hp" -> MAX_HP
            "attack" -> MAX_ATTACK
            "defense" -> MAX_DEFENCE
            "special-attack" -> MAX_SP_ATTACK
            "special-defense" -> MAX_SP_DEFENCE
            "speed" -> MAX_SPEED
            else -> baseStat
        }

    val name: String
        get() = when (stat) {
            "hp" -> "HP"
            "attack" -> "Attack"
            "defense" -> "Defense"
            "special-attack" -> "Sp. Attack"
            "special-defense" -> "Sp. Defense"
            "speed" -> "Speed"
            else -> ""
        }

    companion object {
        const val MAX_HP = 255
        const val MAX_ATTACK = 190
        const val MAX_DEFENCE = 230
        const val MAX_SP_ATTACK = 200
        const val MAX_SP_DEFENCE = 230
        const val MAX_SPEED = 180
    }
}
