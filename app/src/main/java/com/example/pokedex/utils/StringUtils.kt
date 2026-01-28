package com.example.pokedex.utils

import com.example.pokedex.utils.Constants.BAR_URL_IMAGE
import java.util.Locale

object StringUtils {
    fun Long?.formatPokemonID(): String {
        return when (this.toString().length) {
            1 -> "#00$this"
            2 -> "#0$this"
            else -> "#$this"
        }
    }

    fun String?.getIDFromURL(): Long {
        if (this.isNullOrEmpty()) return 0L
        return try {
            val url = this.trimEnd('/')
            val getID = url.substringAfterLast('/')
            getID.toLong()
        } catch (e: Exception) {
            0L
        }
    }

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