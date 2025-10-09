package com.example.pokedex.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface PokemonDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonDetail(pokemonDetail: PokemonDetailEntity)
}