package com.example.pokedex.utils

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
}