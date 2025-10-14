package com.example.pokedex.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pokedex.data.local.dao.PokemonDetailDao
import com.example.pokedex.data.local.dao.PokemonsDao
import com.example.pokedex.data.local.entity.PokemonDetailEntity

@Database(
    entities = [PokemonEntity::class, PokemonDetailEntity::class],
    version = 1
)
@TypeConverters(DatabaseConverter::class)
abstract class PokedexDatabase : RoomDatabase() {

    abstract fun pokemonsDao(): PokemonsDao

    abstract fun pokemonDetailDao(): PokemonDetailDao
}