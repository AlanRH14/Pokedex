package com.example.pokedex.data.mappers

import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.models.type.TypeDto
import com.example.pokedex.domain.models.PokemonType
import com.example.pokedex.utils.StringUtils.capitalized

class TypeMapperImpl : ApiMapper<TypeDto, PokemonType> {

    override fun mapperToDomain(dto: TypeDto): PokemonType {
        return PokemonType(
            id = dto.id ?: 0,
            name = dto.name ?: "",
            doubleDamageFrom = dto.damageRelations?.doubleDamageFrom?.map { (it.name ?: "").capitalized() }
                ?: emptyList(),
            doubleDamageTo = dto.damageRelations?.doubleDamageTo?.map { (it.name ?: "").capitalized() }
                ?: emptyList(),
            halfDamageFrom = dto.damageRelations?.halfDamageFrom?.map { (it.name ?: "").capitalized() }
                ?: emptyList(),
            halfDamageTo = dto.damageRelations?.doubleDamageTo?.map { (it.name ?: "").capitalized() }
                ?: emptyList(),
            noDamageFrom = dto.damageRelations?.noDamageFrom?.map { (it.name ?: "").capitalized() }
                ?: emptyList(),
            noDamageTo = dto.damageRelations?.noDamageTo?.map { (it.name ?: "").capitalized() }
                ?: emptyList(),
        )
    }
}