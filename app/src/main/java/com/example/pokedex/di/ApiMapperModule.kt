package com.example.pokedex.di

import com.example.pokedex.common.ApiMapper
import com.example.pokedex.data.local.entity.PokemonEntity
import com.example.pokedex.data.mappers.PokemonDetailMapperImpl
import com.example.pokedex.data.mappers.PokemonEntityMapperImpl
import com.example.pokedex.data.mappers.PokemonMapperImpl
import com.example.pokedex.data.mappers.SpeciesMapperImpl
import com.example.pokedex.data.mappers.TypeMapperImpl
import com.example.pokedex.data.models.detail.PokemonDetailDto
import com.example.pokedex.data.models.pokemon.PokemonResponse
import com.example.pokedex.data.models.species.SpeciesResponse
import com.example.pokedex.data.models.type.TypeDto
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonDetail
import com.example.pokedex.domain.models.PokemonType
import com.example.pokedex.domain.models.Species
import org.koin.core.qualifier.named
import org.koin.dsl.module

val apiMapperModule = module {
    factory<ApiMapper<PokemonResponse, List<PokemonEntity>>>(named("PokemonEntityMapperImpl")) { PokemonEntityMapperImpl() }
    factory<ApiMapper<List<PokemonEntity>, List<Pokemon>>>(named("PokemonMapperImpl")) { PokemonMapperImpl() }
    single<ApiMapper<PokemonDetailDto, PokemonDetail>>(named("PokemonDetailMapperImpl")) { PokemonDetailMapperImpl() }
    single<ApiMapper<SpeciesResponse, Species>>(named("SpeciesMapperImpl")) { SpeciesMapperImpl() }
    single<ApiMapper<TypeDto, PokemonType>>(named("PokemonTypeMapperImpl")) { TypeMapperImpl() }
}