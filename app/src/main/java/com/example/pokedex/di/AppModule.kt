package com.example.pokedex.di

import com.example.pokedex.presentation.screens.pokedex.PokedexViewModel
import com.example.pokedex.presentation.screens.pokemon_details.PokemonDetailViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { PokedexViewModel(pokemonRepository = get()) }
    viewModel { PokemonDetailViewModel(pokemonDetailRepository = get()) }
}