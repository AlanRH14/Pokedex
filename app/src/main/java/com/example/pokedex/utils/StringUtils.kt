package com.example.pokedex.utils

import com.example.pokedex.utils.Constants.BAR_URL_IMAGE
import java.util.Locale

object StringUtils {
    fun String?.capitalized(): String {
        return this?.replaceFirstChar {
            if (it.isLowerCase())
                it.titlecase(Locale.getDefault())
            else
                it.toString()
        } ?: ""
    }

    fun formatPokemonImageURL(pokemonID: Long?): String {
        return if (pokemonID != null) {
            "$BAR_URL_IMAGE$pokemonID.png"
        } else {
            ""
        }
    }
}