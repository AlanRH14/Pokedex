package com.example.pokedex.data.models.type


import com.example.pokedex.data.models.type.common.NameIconBase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationVii(
    @SerialName("lets-go-pikachu-lets-go-eevee")
    val letsGoPikachuLetsGoEevee: NameIconBase?,
    @SerialName("sun-moon")
    val sunMoon: NameIconBase?,
    @SerialName("ultra-sun-ultra-moon")
    val ultraSunUltraMoon: NameIconBase?
)