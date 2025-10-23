package com.example.pokedex.di

import com.example.pokedex.data.repository.MainRepositoryImpl
import com.example.pokedex.data.repository.PokemonDetailImpl
import com.example.pokedex.data.repository.PokemonPaletteRepositoryImpl
import com.example.pokedex.domain.repository.MainRepository
import com.example.pokedex.domain.repository.PokemonDetailRepository
import com.example.pokedex.domain.repository.PokemonPaletteRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryNetwork = module {
    single<MainRepository> {
        MainRepositoryImpl(
            pokedexService = get(),
            pokemonMapper = get(named("PokemonMapperImpl"))
        )
    }
    single<PokemonDetailRepository> {
        PokemonDetailImpl(
            pokedexService = get(),
            pokemonDetailMapper = get(named("PokemonDetailMapperImpl"))
        )
    }

    single<PokemonPaletteRepository> {
        PokemonPaletteRepositoryImpl(
            bitmapFromURLDataSource = get(),
            paletteDataSource = get()
        )
    }
}