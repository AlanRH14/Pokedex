package com.example.pokedex.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [PokemonEntity::class, PokemonDetailEntity::class],
    version = 1
)
abstract class PokedexDatabase : RoomDatabase() {

    abstract fun pokemonsDao(): PokemonsDao

    abstract fun pokemonDetailDao(): PokemonDetailDao
}