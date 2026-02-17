package com.example.pokedex.data.mappers

import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.local.entity.PokemonEntity
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.utils.StringUtils.formatPokemonID

class PokemonMapperImpl : ApiMapper<PokemonEntity, Pokemon> {

    override fun mapperToDomain(dto: PokemonEntity): Pokemon {
        return Pokemon(
            id = dto.id.formatPokemonID(),
            name = dto.name ?: "",
            url = dto.url ?: "",
            colorPalette = null,
        )
    }
}