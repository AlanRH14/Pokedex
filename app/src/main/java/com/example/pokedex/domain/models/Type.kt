package com.example.pokedex.domain.models

data class Type(
    val slot: Int = 0,
    val type: String = "",
) {

    val icon: String = when (type) {
        "bug" -> "ic_type_bug"
        "dark" -> "ic_type_dark"
        "dragon" -> "ic_type_dragon"
        "electric" -> "ic_type_electric"
        "fairy" -> "ic_type_fairy"
        "fighting" -> "ic_type_fighting"
        "fire" -> "ic_type_fire"
        "flying" -> "ic_type_flying"
        "ghost" -> "ic_type_ghost"
        "grass" -> "ic_type_grass"
        "ground" -> "ic_type_ground"
        "ice" -> "ic_type_ice"
        "normal" -> "ic_type_normal"
        "poison" -> "ic_type_poison"
        "psychic" -> "ic_type_psychic"
        "rock" -> "ic_type_rock"
        "steel" -> "ic_type_steel"
        "water" -> "ic_type_water"
        else -> type
    }
}