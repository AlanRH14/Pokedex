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

    fun Long?.formatPokemonImageURL(): String {
        return if (this != null) {
            "$BAR_URL_IMAGE$this.png"
        } else {
            ""
        }
    }
}