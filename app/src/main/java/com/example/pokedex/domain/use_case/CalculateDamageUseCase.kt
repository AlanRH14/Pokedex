package com.example.pokedex.domain.use_case

import com.example.pokedex.domain.models.PokemonType

class CalculateDamageUseCase {

    fun calculateDefenseMultiplier(types: List<PokemonType>): Map<String, Double> {
        if (types.isEmpty()) return emptyMap()


        return emptyMap()
    }
}