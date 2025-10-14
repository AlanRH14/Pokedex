package com.example.pokedex.data.mappers

import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.models.PokemonResponse
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.utils.Constants
import com.example.pokedex.utils.StringUtils.capitalized
import java.util.Locale

class PokemonMapperImpl : ApiMapper<PokemonResponse, List<Pokemon>> {

    override fun mapperToDomain(dto: PokemonResponse): List<Pokemon> {
        return dto.results?.mapIndexed { index, pokemon ->
            Pokemon(
                id = formatPokemonID(index),
                name = pokemon.name.capitalized(),
                url = "${Constants.BAR_URL_IMAGE}${index + 1}.png"
            )
        } ?: emptyList()
    }
}