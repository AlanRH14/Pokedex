package com.example.pokedex.data

import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.models.PokemonDto
import com.example.pokedex.data.models.PokemonResponse
import com.example.pokedex.domain.models.Pokemon

class PokemonMapperImpl: ApiMapper<PokemonResponse, List<Pokemon>> {

    override fun mapperToDomain(dto: PokemonResponse): List<Pokemon> {
        return dto.results?.map {
            Pokemon(
                id = 0,
                name = it.name ?: "",
                url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"
            )
        } ?: emptyList()
    }
}