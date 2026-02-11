package com.example.pokedex.data.mappers

import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.local.entity.PokemonEntity
import com.example.pokedex.domain.models.Pokemon

class PokemonEntityMapperImpl: ApiMapper<List<PokemonEntity>, List<Pokemon>> {

    override fun mapperToDomain(dto: List<PokemonEntity>): List<Pokemon> {
        TODO("Not yet implemented")
    }
}