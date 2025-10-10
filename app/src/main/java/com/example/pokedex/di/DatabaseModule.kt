package com.example.pokedex.di

import androidx.room.Room
import com.example.pokedex.data.local.PokedexDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            PokedexDatabase::class.java,
            ""
        )
    }
}