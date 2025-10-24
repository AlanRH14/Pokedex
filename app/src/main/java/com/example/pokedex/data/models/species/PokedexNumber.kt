package com.example.pokedex.data.models.species


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokedexNumber(
    @SerialName("entry_number")
    val entryNumber: Int?,
    @SerialName("pokedex")
    val pokedex: Pokedex?
)