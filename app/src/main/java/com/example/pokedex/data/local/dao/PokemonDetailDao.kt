package com.example.pokedex.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokedex.data.local.entity.PokemonDetailEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDetailDao {

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertPokemonDetail(pokemonDetail: PokemonDetailEntity)

    @Query("SELECT * FROM PokemonDetailEntity WHERE name = :name")
    fun getPokemonDetail(name: String): Flow<PokemonDetailEntity>
}