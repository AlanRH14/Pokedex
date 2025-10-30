package com.example.pokedex.data.models.type

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Sprites(
    @SerialName("generation-iii")
    val generationIii: GenerationIii? = null,
    @SerialName("generation-iv")
    val generationIv: GenerationIv? = null,
    @SerialName("generation-ix")
    val generationIx: GenerationIx? = null,
    @SerialName("generation-v")
    val generationV: GenerationV? = null,
    @SerialName("generation-vi")
    val generationVi: GenerationVi? = null,
    @SerialName("generation-vii")
    val generationVii: GenerationVii? = null,
    @SerialName("generation-viii")
    val generationViii: GenerationViii? = null
)