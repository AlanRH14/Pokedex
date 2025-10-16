package com.example.pokedex.data.remote

import coil3.Bitmap
import com.example.pokedex.domain.models.PokemonPaletteColors

interface PaletteDataSource {
    suspend fun generatePalette(bitmap: Bitmap): PokemonPaletteColors
}