package com.example.pokedex.data.mappers

import androidx.core.net.toUri
import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.local.entity.PokemonEntity
import com.example.pokedex.data.models.pokemon.PokemonResponse
import com.example.pokedex.utils.Constants
import com.example.pokedex.utils.StringUtils.capitalized
import com.example.pokedex.utils.StringUtils.getIDFromURL

class PokemonEntityMapperImpl : ApiMapper<PokemonResponse, List<PokemonEntity>> {

    override fun mapperToDomain(dto: PokemonResponse): List<PokemonEntity> {
        return try {
            dto.results?.map { pokemonRes ->
                val pokemonID = pokemonRes.url.getIDFromURL()
                PokemonEntity(
                    id = pokemonID,
                    page = getOffsetFromUrl(url = dto.next) ?: 0,
                    name = pokemonRes.name.capitalized(),
                    url = "${Constants.BAR_URL_IMAGE}${pokemonID}.png"
                )
            } ?: emptyList()
        } catch (_: Exception) {
            emptyList()
        }
    }

    private fun getOffsetFromUrl(url: String?): Int? {
        if (url == null) return null

        return try {
            val uri = url.toUri()
            uri.getQueryParameter("offset")?.toInt()
        } catch (_: Exception) {
            null
        }
    }
}