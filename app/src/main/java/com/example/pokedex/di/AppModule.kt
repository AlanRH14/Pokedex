package com.example.pokedex.di

import com.example.pokedex.presentation.screens.pokedex.PokemonViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { PokemonViewModel(pokemonRepository = get()) }
}