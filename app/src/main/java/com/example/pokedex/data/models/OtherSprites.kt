package com.example.pokedex.data.models

import kotlinx.serialization.SerialName


data class OtherSprites(
    @SerialName("official_artwork") val officialArtwork: OfficialArtwork? = null
)
