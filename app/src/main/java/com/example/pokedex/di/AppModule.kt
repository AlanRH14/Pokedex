package com.example.pokedex.di

import com.example.pokedex.presentation.PokemonViewModel
import org.koin.dsl.module

val appModule = module {
    single { PokemonViewModel(pokemonRepository = get()) }
}