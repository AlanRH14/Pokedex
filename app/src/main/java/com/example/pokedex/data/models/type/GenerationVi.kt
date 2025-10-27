package com.example.pokedex.data.models.type


import com.example.pokedex.data.models.type.common.NameIconBase
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationVi(
    @SerialName("omega-ruby-alpha-sapphire")
    val omegaRubyAlphaSapphire: OmegaRubyAlphaSapphire?,
    @SerialName("x-y")
    val xY: NameIconBase?
)