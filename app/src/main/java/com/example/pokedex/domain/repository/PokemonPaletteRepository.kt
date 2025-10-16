package com.example.pokedex.domain.repository

import com.example.pokedex.domain.models.Pokemon

interface PokemonPaletteRepository {
    suspend fun generatePokemonPalette(pokemon: Pokemon): Pokemon
}