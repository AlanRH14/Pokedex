package com.example.pokedex.di

import com.example.pokedex.data.PokemonDetailMapperImpl
import com.example.pokedex.data.PokemonMapperImpl
import org.koin.dsl.module

val apiMapperModule = module {
    single { PokemonMapperImpl() }
    single { PokemonDetailMapperImpl() }
}