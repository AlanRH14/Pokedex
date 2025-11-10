package com.example.pokedex.di

import com.example.pokedex.domain.use_case.CalculateDamageUseCase
import com.example.pokedex.presentation.screens.pokedex.PokedexViewModel
import com.example.pokedex.presentation.screens.pokemon_details.PokemonDetailViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { CalculateDamageUseCase() }

    viewModel { PokedexViewModel(pokemonRepository = get(), pokemonPaletteRepository = get()) }

    viewModel { PokemonDetailViewModel(pokemonDetailRepository = get(), pokemonPaletteRepository = get(), calculateDamageUseCase = get()) }

}