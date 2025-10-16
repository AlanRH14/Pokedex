package com.example.pokedex.data.repository

import com.example.pokedex.data.remote.ImageRemoteDataSource
import com.example.pokedex.data.remote.PaletteDataSource
import com.example.pokedex.domain.models.PokemonPaletteColors
import com.example.pokedex.domain.repository.PokemonPaletteRepository

class PokemonPaletteRepositoryImpl(
    private val imageRemoteDataSource: ImageRemoteDataSource,
    private val paletteDataSource: PaletteDataSource
): PokemonPaletteRepository {

    override suspend fun generatePokemonPalette(pokemonURL: String): PokemonPaletteColors {
        return
    }
}