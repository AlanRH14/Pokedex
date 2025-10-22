package com.example.pokedex.di

import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.mappers.PokemonDetailMapperImpl
import com.example.pokedex.data.mappers.PokemonMapperImpl
import com.example.pokedex.data.models.detail.PokemonDetailDto
import com.example.pokedex.data.models.PokemonResponse
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonDetail
import org.koin.core.qualifier.named
import org.koin.dsl.module

val apiMapperModule = module {
    single<ApiMapper<PokemonResponse, List<Pokemon>>>(named("PokemonMapperImpl")) { PokemonMapperImpl() }
    single<ApiMapper<PokemonDetailDto, PokemonDetail>>(named("PokemonDetailMapperImpl")) { PokemonDetailMapperImpl() }
}