package com.example.pokedex.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonDetailEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val height: String,
    val weight: String,
    val experience: String,
    val sprites: String,
    val types: String,
    val stats: String,
    val abilities: String
)