package com.example.pokedex.domain.repository

interface PokemonPaletteRepository {
    suspend fun generatePokemonPalette(pokemonURL: String): PokemonPaletteRepository
}