package com.example.pokedex.domain.use_case

import com.example.pokedex.domain.models.PokemonType

class CalculateDamageUseCase {
    fun calculateDefenseMultiplier(types: List<PokemonType>): Map<String, Double> {
        if (types.isEmpty()) return emptyMap()
        val allAttackTypes = mutableSetOf<String>()

        types.forEach { type ->
            allAttackTypes += type.doubleDamageFrom
            allAttackTypes += type.halfDamageFrom
            allAttackTypes += type.noDamageFrom
        }

        val result = mutableMapOf<String, Double>()

        for (attackType in allAttackTypes) {
            var multiplier = 1.0

            for (type in types) {
                if (attackType in type.doubleDamageFrom) multiplier *= 2.0
                if (attackType in type.halfDamageFrom) multiplier *= 0.5
                if (attackType in type.noDamageFrom) multiplier *= 0.0
            }

            result[attackType] = multiplier
        }

        return result.toSortedMap()
    }
}