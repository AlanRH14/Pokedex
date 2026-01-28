package com.example.pokedex.data.mappers

import android.util.Log
import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.models.pokemon.PokemonResponse
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.utils.Constants
import com.example.pokedex.utils.StringUtils.capitalized
import com.example.pokedex.utils.StringUtils.formatPokemonID
import com.example.pokedex.utils.StringUtils.getIDFromURL

class PokemonMapperImpl : ApiMapper<PokemonResponse, List<Pokemon>> {
    override fun mapperToDomain(dto: PokemonResponse): List<Pokemon> {
        return dto.results?.mapIndexed { index, pokemon ->
            Log.d("PokemonMapperImpl", "Pokemon: ${pokemon.url.getIDFromURL().formatPokemonID()}")
            Pokemon(
                id = pokemon.url.getIDFromURL().formatPokemonID(),
                name = pokemon.name.capitalized(),
                url = "${Constants.BAR_URL_IMAGE}${index + 1}.png"
            )
        } ?: emptyList()
    }
}