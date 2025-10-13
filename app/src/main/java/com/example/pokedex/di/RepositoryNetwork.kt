package com.example.pokedex.di

import com.example.pokedex.data.repository.MainRepositoryImpl
import com.example.pokedex.data.repository.PokemonDetailImpl
import com.example.pokedex.domain.repository.MainRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryNetwork = module {
    single<MainRepository> { MainRepositoryImpl(pokedexService = get(named("PokemonMapperImpl")), pokemonMapper = get()) }
    single { PokemonDetailImpl(pokedexService = get(named("PokemonDetailMapperImpl")), pokemonDetailMapper = get()) }
}