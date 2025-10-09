package com.example.pokedex.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemons(pokemonS: List<PokemonEntity>)

    @Query("SELECT * FROM pokemonEntity WHERE page = :page")
    fun getPokemons(page: Int): Flow<List<PokemonEntity>>


}