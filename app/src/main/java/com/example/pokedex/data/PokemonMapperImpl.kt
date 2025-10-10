package com.example.pokedex.data

import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.models.PokemonResponse
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.utils.Constants.BAR_URL_IMAGE

class PokemonMapperImpl: ApiMapper<PokemonResponse, List<Pokemon>> {

    override fun mapperToDomain(dto: PokemonResponse): List<Pokemon> {
        return dto.results?.mapIndexed { index, pokemon ->
            Pokemon(
                id = 0,
                name = pokemon.name ?: "",
                url = BAR_URL_IMAGE
            )
        } ?: emptyList()
    }
}