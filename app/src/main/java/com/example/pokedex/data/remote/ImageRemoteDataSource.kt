package com.example.pokedex.data.remote

import coil3.Bitmap

interface ImageRemoteDataSource {
    suspend fun generatePaletteFromURL(pokemonURL: String): Bitmap?
}