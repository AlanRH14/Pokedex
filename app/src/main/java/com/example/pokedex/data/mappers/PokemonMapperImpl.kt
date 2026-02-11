package com.example.pokedex.data.mappers

import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.local.entity.PokemonEntity
import com.example.pokedex.data.models.pokemon.PokemonResponse
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.utils.Constants
import com.example.pokedex.utils.StringUtils.capitalized
import com.example.pokedex.utils.StringUtils.formatPokemonID
import com.example.pokedex.utils.StringUtils.getIDFromURL

class PokemonMapperImpl : ApiMapper<List<PokemonEntity>, List<Pokemon>> {
    override fun mapperToDomain(dto: List<PokemonEntity>): List<Pokemon> {
        return dto.map { pokemonEntity ->
            Pokemon(
                id = pokemonEntity.id.formatPokemonID(),
                name = pokemonEntity.name ?: "",
                url = pokemonEntity.url ?: "",
                colorPalette = null,
            )
        }
    }
}