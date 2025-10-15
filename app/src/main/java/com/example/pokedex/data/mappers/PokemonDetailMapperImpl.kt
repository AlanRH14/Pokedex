package com.example.pokedex.data.mappers

import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.models.PokemonDetailDto
import com.example.pokedex.domain.models.PokemonDetail
import com.example.pokedex.domain.models.Sprites
import com.example.pokedex.domain.models.Stat
import com.example.pokedex.domain.models.Type
import com.example.pokedex.utils.StringUtils.capitalized
import com.example.pokedex.utils.StringUtils.formatPokemonID
import com.example.pokedex.utils.StringUtils.formatPokemonImageURL

class PokemonDetailMapperImpl : ApiMapper<PokemonDetailDto, PokemonDetail> {

    override fun mapperToDomain(dto: PokemonDetailDto): PokemonDetail {
        return PokemonDetail(
            id = dto.id.formatPokemonID(),
            name = dto.name.capitalized(),
            url = dto.id.formatPokemonImageURL(),
            height = (dto.height ?: 0) / 10F,
            weight = (dto.weight ?: 0) / 10F,
            sprites = Sprites(
                frontDefault = dto.sprites?.frontDefault ?: "",
                backDefault = dto.sprites?.backDefault ?: "",
                officialArtwork = dto.sprites?.other?.officialArtwork?.frontDefault ?: ""
            ),
            types = dto.types?.map {
                Type(
                    slot = it.slot ?: 0,
                    type = it.type?.name.capitalized()
                )
            } ?: emptyList(),
            stats = dto.stats?.map {
                Stat(
                    baseStat = it.baseStat ?: 0,
                    stat = it.stat?.name ?: "",
                )
            } ?: emptyList(),
            abilities = dto.abilities?.map { it.ability?.name ?: "" } ?: emptyList()
        )
    }
}