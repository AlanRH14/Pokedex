package com.example.pokedex.data.models.species

import com.example.pokedex.data.models.common.NameUrlBase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokedexNumber(
    @SerialName("entry_number")
    val entryNumber: Int?,
    @SerialName("pokedex")
    val pokedex: NameUrlBase?
)