package com.example.pokedex.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OtherSprites(
    @SerialName("official_artwork") val officialArtwork: OfficialArtwork? = null
)
