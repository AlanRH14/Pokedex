package com.example.pokedex.data.mappers

import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.models.type.TypeDto
import com.example.pokedex.domain.models.PokemonType

class TypeMapperImpl : ApiMapper<TypeDto, PokemonType> {

    override fun mapperToDomain(dto: TypeDto): PokemonType {
        return PokemonType(
            id = dto.id ?: 0,
            name = dto.name ?: "",
            doubleDamageFrom = dto.damageRelations?.doubleDamageFrom?.map { it.name ?: "" }
                ?: emptyList(),
            doubleDamageTo = dto.damageRelations?.doubleDamageTo?.map { it.name ?: "" }
                ?: emptyList(),
            halfDamageFrom = dto.damageRelations?.halfDamageFrom?.map { it.name ?: "" }
                ?: emptyList(),
            halfDamageTo = dto.damageRelations?.doubleDamageTo?.map { it.name ?: "" }
                ?: emptyList(),
            noDamageFrom = dto.damageRelations?.noDamageFrom?.map { it.name ?: "" }
                ?: emptyList(),
            noDamageTo = dto.damageRelations?.noDamageTo?.map { it.name ?: "" }
                ?: emptyList(),
        )
    }
}