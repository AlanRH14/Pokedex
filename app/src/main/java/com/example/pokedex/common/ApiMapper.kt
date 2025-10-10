package com.example.pokedex.common

interface ApiMapper<Dto, Domain> {
    fun mapperToDomain(dto: Dto): Domain
}