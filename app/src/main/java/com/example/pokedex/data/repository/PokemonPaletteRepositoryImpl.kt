package com.example.pokedex.data.repository

import com.example.pokedex.data.remote.BitmapFromURLDataSource
import com.example.pokedex.data.remote.PaletteDataSource
import com.example.pokedex.domain.models.PokemonPaletteColors
import com.example.pokedex.domain.repository.PokemonPaletteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonPaletteRepositoryImpl(
    private val bitmapFromURLDataSource: BitmapFromURLDataSource,
    private val paletteDataSource: PaletteDataSource
): PokemonPaletteRepository {

    private val paletteCache = mutableMapOf<String, PokemonPaletteColors>()

    override suspend fun generatePokemonPalette(pokemonURL: String): PokemonPaletteColors? =
        withContext(Dispatchers.IO) {
            try {
                paletteCache[pokemonURL]?.let { return@withContext  it }
                val bitmap = bitmapFromURLDataSource.generatePaletteFromURL(pokemonURL = pokemonURL)
                val palette = bitmap?.let { paletteDataSource.generatePalette(bitmap) }
                palette?.also { paletteCache[pokemonURL] = it }
            } catch (e: Exception) {
                print("Error: ${e.message}")
                null
            }
        }
}