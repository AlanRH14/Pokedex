package com.example.pokedex.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonEntity(
    val page: Int = 0,
    @PrimaryKey val id: Long,
    val name: String,
    val url: String,
)
