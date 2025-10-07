package com.example.pokedex.domain.models

import com.example.pokedex.data.models.OfficialArtwork
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class OtherSprites(
    val officialArtwork: OfficialArtwork? = null
)
