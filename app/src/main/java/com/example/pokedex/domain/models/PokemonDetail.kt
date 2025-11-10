package com.example.pokedex.domain.models

import java.util.SortedMap

data class PokemonDetail(
    val id: String = "",
    val name: String = "",
    val url: String = "",
    val height: Float = 0F,
    val weight: Float = 0F,
    val colorPalette: PokemonPaletteColors? = null,
    val sprites: Sprites = Sprites(),
    val types: List<Type> = emptyList(),
    val stats: List<Stat> = emptyList(),
    val abilities: List<String> = emptyList(),
    val species: Species = Species(),
    val pokemonDamage: SortedMap<Double, List<String>> = sortedMapOf()
)
