package com.example.pokedex.di

import com.example.pokedex.data.repository.MainRepositoryImpl
import com.example.pokedex.data.repository.PokemonDetailImpl
import org.koin.dsl.module

val repositoryNetwork = module {
    single { MainRepositoryImpl(pokedexService = get(), pokemonMapper = get()) }
    single { PokemonDetailImpl(pokedexService = get(), pokemonDetailMapper = get()) }
}