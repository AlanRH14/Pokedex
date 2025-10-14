package com.example.pokedex.utils

object StringUtils {

    fun String?.capitalized(): String {
        return this?.replaceFirstChar {
            if (it.isLowerCase())
                it.uppercase()
            else
                it.toString()
        } ?: ""
    }
}