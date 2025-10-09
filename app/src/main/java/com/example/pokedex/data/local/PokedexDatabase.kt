package com.example.pokedex.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [PokemonEntity::class, PokemonDetailEntity::class],
    version = 1
)
@TypeConverters(DatabaseConverter::class)
abstract class PokedexDatabase : RoomDatabase() {

    abstract fun pokemonsDao(): PokemonsDao

    abstract fun pokemonDetailDao(): PokemonDetailDao
}