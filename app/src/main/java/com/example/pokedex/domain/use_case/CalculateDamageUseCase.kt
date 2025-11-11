package com.example.pokedex.domain.use_case

import com.example.pokedex.domain.models.PokemonType
import com.example.pokedex.domain.models.Type

class CalculateDamageUseCase {
    fun calculateDefenseMultiplier(types: List<PokemonType>): Map<Double, List<Type>> {
        if (types.isEmpty()) return sortedMapOf()
        val allAttackTypes = mutableSetOf<Type>()

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

            result[attackType.type] = multiplier
        }

        return result.entries
            .groupBy({ value -> value.value }, { key -> Type(type = key.key) })
            .toSortedMap(compareByDescending { compare -> compare })
    }
}