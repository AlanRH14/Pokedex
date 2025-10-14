package com.example.pokedex.data

import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.models.PokemonResponse
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.utils.Constants.BAR_URL_IMAGE
import java.util.Locale

class PokemonMapperImpl : ApiMapper<PokemonResponse, List<Pokemon>> {

    override fun mapperToDomain(dto: PokemonResponse): List<Pokemon> {
        return dto.results?.mapIndexed { index, pokemon ->
            Pokemon(
                id = formatPokemonID(index),
                name = pokemon.name?.capitalized() ?: "",
                url = "$BAR_URL_IMAGE${index + 1}.png"
            )
        } ?: emptyList()
    }

    private fun formatPokemonID(id: Int): String {
        return when (id.toString().length) {
            1 -> "#00$id"
            2 -> "#0$id"
            else -> "#$id"
        }
    }

    private fun String.capitalized(): String {
        return this.replaceFirstChar {
            if (it.isLowerCase())
                it.titlecase(Locale.getDefault())
            else
                it.toString()
        }
    }
}