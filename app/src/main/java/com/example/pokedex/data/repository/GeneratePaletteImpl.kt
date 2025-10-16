package com.example.pokedex.data.repository

import androidx.palette.graphics.Palette
import coil3.Bitmap
import com.example.pokedex.data.remote.ImageRemoteDataSource
import com.example.pokedex.data.remote.PaletteDataSource
import com.example.pokedex.domain.models.PokemonPaletteColors

class GeneratePaletteImpl(
    private val imageRemoteDataSource: ImageRemoteDataSource
): PaletteDataSource {

    override suspend fun generatePalette(bitmap: Bitmap): PokemonPaletteColors {
        val palette = Palette.from(bitmap)
    }
}