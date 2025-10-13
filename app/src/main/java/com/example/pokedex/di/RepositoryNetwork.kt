package com.example.pokedex.di

import com.example.pokedex.data.repository.MainRepositoryImpl
import com.example.pokedex.data.repository.PokemonDetailImpl
import com.example.pokedex.domain.repository.MainRepository
import com.example.pokedex.domain.repository.PokemonDetailRepository
import org.koin.dsl.module

val repositoryNetwork = module {
    single<MainRepository> { MainRepositoryImpl(pokedexService = get(), pokemonMapper = get()) }
    single<PokemonDetailRepository> { PokemonDetailImpl(pokedexService = get(), pokemonDetailMapper = get()) }
}