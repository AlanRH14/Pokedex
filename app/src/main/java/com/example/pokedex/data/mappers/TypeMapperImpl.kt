package com.example.pokedex.data.mappers

import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.models.type.TypeDto
import com.example.pokedex.domain.models.PokemonType

class TypeMapperImpl: ApiMapper<TypeDto, PokemonType> {

    override fun mapperToDomain(dto: TypeDto): PokemonType {
        return PokemonType(
            doubleDamage = dto.damageRelations.doubleDamageFrom.map { it.name } ?: emptyList(),

        )
    }
}