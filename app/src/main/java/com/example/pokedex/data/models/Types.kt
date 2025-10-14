package com.example.pokedex.data.models

import kotlinx.serialization.SerialName

data class Types(
    @SerialName("name") val name: String? = null,
    @SerialName("url") val url: String? = null
)
