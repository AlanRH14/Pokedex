package com.example.pokedex.navigation

import kotlinx.serialization.Serializable

interface NavRoute {
    @Serializable
    data object PokemonsScreen: NavRoute

    @Serializable
    data class PokemonDetailScreen(val pokemonName: String): NavRoute
}