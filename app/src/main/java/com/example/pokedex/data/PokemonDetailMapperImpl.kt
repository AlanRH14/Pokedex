package com.example.pokedex.data

import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.models.PokemonDetailDto
import com.example.pokedex.domain.models.PokemonDetail

class PokemonDetailMapperImpl : ApiMapper<PokemonDetailDto, PokemonDetail> {

    override fun mapperToDomain(dto: PokemonDetailDto): PokemonDetail {
        return PokemonDetail(
            id = formatPokemonID(id = dto.id),
            name = dto.name ?: ""
        )
    }

    private fun formatPokemonID(id: Long): String {
        return when (id.toString().length) {
            1 -> "#00$id"
            2 -> "#0$id"
            else -> "#$id"
        }
    }
}