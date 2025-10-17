package com.example.pokedex.data.repository

import com.example.pokedex.data.remote.ImageRemoteDataSource
import com.example.pokedex.data.remote.PaletteDataSource
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonPaletteColors
import com.example.pokedex.domain.repository.PokemonPaletteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonPaletteRepositoryImpl(
    private val imageRemoteDataSource: ImageRemoteDataSource,
    private val paletteDataSource: PaletteDataSource
): PokemonPaletteRepository {

    override suspend fun generatePokemonPalette(pokemonURL: String): PokemonPaletteColors? =
        withContext(Dispatchers.IO) {
            try {
                val bitmap = imageRemoteDataSource.generatePaletteFromURL(pokemonURL)
                if (bitmap != null) {
                    paletteDataSource.generatePalette(bitmap = bitmap)
                } else {
                    null
                }
            } catch (e: Exception) {
                print("Error: ${e.message}")
                null
            }
        }
}