package com.example.pokedex.data.repository

import coil3.Bitmap
import com.example.pokedex.data.remote.PaletteDataSource
import com.example.pokedex.domain.models.PokemonPaletteColors

class GeneratePaletteImpl: PaletteDataSource {

    override suspend fun generatePalette(bitmap: Bitmap): PokemonPaletteColors {
        TODO("Not yet implemented")
    }
}