package com.example.pokedex.data.mappers

import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.models.species.FlavorTextEntry
import com.example.pokedex.data.models.species.Genera
import com.example.pokedex.data.models.species.SpeciesResponse
import com.example.pokedex.domain.models.Species

class SpeciesMapperImpl : ApiMapper<SpeciesResponse, Species> {

    override fun mapperToDomain(dto: SpeciesResponse): Species {
        return Species(
            id = dto.id ?: 0,
            name = dto.name ?: "",
            baseHappiness = dto.baseHappiness ?: 0,
            captureRate = dto.captureRate ?: 0,
            idEvolutionChain = "",
            description = dto.flavorTextEntries?.getDescription() ?: "",
            pokemonClass = dto.genera?.getPokemonClass() ?: "",
            habitat = dto.habitat?.name ?: "",
            isBaby = dto.isBaby ?: false,
            isLegendary = dto.isLegendary ?: false,
            isMythical = dto.isMythical ?: false
        )
    }

    private fun List<FlavorTextEntry>.getDescription(): String {
        var description = ""
        this.forEach {
            if (it.language?.name == "en") {
                description = it.flavorText ?: ""
            }
        }

        return description
    }

    private fun List<Genera>.getPokemonClass(): String {
        var genera = ""
        this.forEach {
            if (it.language?.name == "en") {
                genera = it.genus ?: ""
            }
        }
        return genera
    }
}