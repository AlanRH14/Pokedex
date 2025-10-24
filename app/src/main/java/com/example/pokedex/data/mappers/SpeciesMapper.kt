package com.example.pokedex.data.mappers

import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.models.species.SpeciesResponse
import com.example.pokedex.domain.models.Species

class SpeciesMapper: ApiMapper<SpeciesResponse, Species> {

    override fun mapperToDomain(dto: SpeciesResponse): Species {
        return Species(

        )
    }
}