package com.example.pokedex.data.models.type


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationVii(
    @SerialName("lets-go-pikachu-lets-go-eevee")
    val letsGoPikachuLetsGoEevee: LetsGoPikachuLetsGoEevee?,
    @SerialName("sun-moon")
    val sunMoon: SunMoon?,
    @SerialName("ultra-sun-ultra-moon")
    val ultraSunUltraMoon: UltraSunUltraMoon?
)