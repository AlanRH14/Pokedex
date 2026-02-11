package com.example.pokedex.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonEntity(
    @PrimaryKey val id: Long,
    val page: Int?,
    val name: String?,
    val url: String?,
)