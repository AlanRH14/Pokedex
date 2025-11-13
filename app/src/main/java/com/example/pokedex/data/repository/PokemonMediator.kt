package com.example.pokedex.data.repository

import androidx.paging.PagingSource
import com.example.pokedex.data.remote.PokedexService

class PokemonMediator(
    private val pokedexService: PokedexService,
): PagingSource<Int, Pokemo> {
}