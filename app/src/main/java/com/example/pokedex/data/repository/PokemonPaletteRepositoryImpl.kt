package com.example.pokedex.data.repository

import com.example.pokedex.data.remote.ImageRemoteDataSource
import com.example.pokedex.data.remote.PaletteDataSource
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repository.PokemonPaletteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonPaletteRepositoryImpl(
    private val imageRemoteDataSource: ImageRemoteDataSource,
    private val paletteDataSource: PaletteDataSource
): PokemonPaletteRepository {

    override suspend fun generatePokemonPalette(pokemon: Pokemon): Pokemon =
        withContext(Dispatchers.IO) {
            try {
                val bitmap = imageRemoteDataSource.generatePaletteFromURL(pokemon.url)
                if (bitmap != null) {
                    val palette = paletteDataSource.generatePalette(bitmap = bitmap)
                    pokemon.copy(colorPalette = palette)
                } else {
                    pokemon
                }
            } catch (e: Exception) {
                pokemon
            }
        }
}