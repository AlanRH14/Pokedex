package com.example.pokedex.data.remote

import coil3.Bitmap

interface BitmapFromURLDataSource {
    suspend fun generatePaletteFromURL(pokemonURL: String): Bitmap?
}