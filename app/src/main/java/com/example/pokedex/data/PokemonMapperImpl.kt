package com.example.pokedex.data

import android.util.Log
import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.models.PokemonResponse
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.utils.Constants.BAR_URL_IMAGE

class PokemonMapperImpl : ApiMapper<PokemonResponse, List<Pokemon>> {

    override fun mapperToDomain(dto: PokemonResponse): List<Pokemon> {

        return dto.results?.mapIndexed { index, pokemon ->
            val url = "$BAR_URL_IMAGE${index + 1}.png"
            Log.d("LordMiau", "URL: $url")
            Pokemon(
                id = formatPokemonID(index),
                name = pokemon.name ?: "",
                url = url
            )
        } ?: emptyList()
    }

    private fun formatPokemonID(id: Int): String {
        return when (id.toString().length) {
            1 -> "#00$id"
            2 -> "0$id"
            else -> "#$id"
        }
    }
}