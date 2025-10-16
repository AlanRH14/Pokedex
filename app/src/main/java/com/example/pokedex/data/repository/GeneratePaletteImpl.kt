package com.example.pokedex.data.repository

import android.graphics.Color
import androidx.palette.graphics.Palette
import coil3.Bitmap
import com.example.pokedex.data.remote.PaletteDataSource
import com.example.pokedex.domain.models.PokemonPaletteColors

class GeneratePaletteImpl: PaletteDataSource {

    override suspend fun generatePalette(bitmap: Bitmap): PokemonPaletteColors {
        val palette = Palette.from(bitmap).generate()

        return PokemonPaletteColors(
            domainColor = palette.getDominantColor(DEFAULT_COLOR),
            vibrantColor = palette.vibrantSwatch?.rgb,
            mutedColor = palette.mutedSwatch?.rgb,
            darkVibrantColor = palette.darkVibrantSwatch?.rgb,
            onDominantColor = palette.getDominantColor(DEFAULT_COLOR).calculateContrastColor()
        )
    }

    private fun Int.calculateContrastColor(): Int {
        val luminance = 0.299 * Color.red(this) +
                0.587 * Color.green(this) +
                0.114 * Color.blue(this)

        return if (luminance > 186) Color.BLACK else Color.WHITE
    }

    companion object {
        private const val DEFAULT_COLOR = 0xFF757575.toInt()
    }
}