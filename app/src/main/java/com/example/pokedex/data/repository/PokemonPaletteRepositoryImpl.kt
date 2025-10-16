package com.example.pokedex.data.repository

import com.example.pokedex.data.remote.ImageRemoteDataSource
import com.example.pokedex.data.remote.PaletteDataSource

class PokemonPaletteRepositoryImpl(
    private val imageRemoteDataSource: ImageRemoteDataSource,
    private val paletteDataSource: PaletteDataSource
) {


}