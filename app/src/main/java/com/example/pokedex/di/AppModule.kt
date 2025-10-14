package com.example.pokedex.di

import com.example.pokedex.presentation.screens.pokedex.PokemonViewModel
import com.example.pokedex.presentation.screens.pokemon_details.PokemonDetailViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { PokemonViewModel(pokemonRepository = get()) }
    viewModel { PokemonDetailViewModel(pokemonDetailRepository = get()) }
}