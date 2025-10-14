package com.example.pokedex.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokedex.data.local.PokemonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonsDao {

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertPokemons(pokemonS: List<PokemonEntity>)

    @Query("SELECT * FROM pokemonEntity WHERE page = :page")
    fun getCurrentPagePokemons(page: Int): Flow<List<PokemonEntity>>

    @Query("SELECT * FROM pokemonEntity WHERE page <= :page")
    fun getAllPokemons(page: Int): Flow<List<PokemonEntity>>
}