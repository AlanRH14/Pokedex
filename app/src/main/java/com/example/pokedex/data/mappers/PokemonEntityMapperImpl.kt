package com.example.pokedex.data.mappers

import android.util.Log
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
                    page = 0,
                    name = pokemonRes.name.capitalized(),
                    url = "${Constants.BAR_URL_IMAGE}${pokemonID}.png"
                )
            } ?: emptyList()
        } catch (e: Exception) {
            Log.d("LordMiau", "Exception PokemonEntityMapperImpl: ${e.message}")
            emptyList()
        }
    }
}