package com.example.pokedex.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokedex.data.local.entity.PokemonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemons(pokemons: List<PokemonEntity>)

    @Query("SELECT * FROM pokemonEntity")
    fun getCurrentPagePokemons(): PagingSource<Int, PokemonEntity>

    @Query("SELECT * FROM pokemonEntity")
    fun getAllPokemons(): PagingSource<Int, PokemonEntity>
}