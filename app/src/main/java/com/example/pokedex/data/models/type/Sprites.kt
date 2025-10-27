package com.example.pokedex.data.models.type


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Sprites(
    @SerialName("generation-iii")
    val generationIii: GenerationIii?,
    @SerialName("generation-iv")
    val generationIv: GenerationIv?,
    @SerialName("generation-ix")
    val generationIx: GenerationIx?,
    @SerialName("generation-v")
    val generationV: GenerationV?,
    @SerialName("generation-vi")
    val generationVi: GenerationVi?,
    @SerialName("generation-vii")
    val generationVii: GenerationVii?,
    @SerialName("generation-viii")
    val generationViii: GenerationViii?
)