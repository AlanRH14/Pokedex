package com.example.pokedex.domain.repository

import com.example.pokedex.domain.models.PokemonPaletteColors

interface PokemonPaletteRepository {
    suspend fun generatePokemonPalette(pokemonURL: String): PokemonPaletteColors?
}