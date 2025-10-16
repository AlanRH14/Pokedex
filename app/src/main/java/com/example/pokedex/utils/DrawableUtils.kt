package com.example.pokedex.utils

import androidx.annotation.DrawableRes
import com.example.pokedex.R

object DrawableUtils {
    val String.icon : Int @DrawableRes get() =
        when (this) {
            "bug" -> R.drawable.ic_type_bug
            "dark" -> R.drawable.ic_type_dark
            "dragon" -> R.drawable.ic_type_dragon
            "electric" -> R.drawable.ic_type_electric
            "fairy" -> R.drawable.ic_type_fairy
            "fighting" -> R.drawable.ic_type_fighting
            "fire" -> R.drawable.ic_type_fire
            "flying" -> R.drawable.ic_type_flying
            "ghost" -> R.drawable.ic_type_ghost
            "grass" -> R.drawable.ic_type_grass
            "ground" -> R.drawable.ic_type_ground
            "ice" -> R.drawable.ic_type_ice
            "normal" -> R.drawable.ic_type_normal
            "poison" -> R.drawable.ic_type_poison
            "psychic" -> R.drawable.ic_type_psychic
            "rock" -> R.drawable.ic_type_rock
            "steel" -> R.drawable.ic_type_steel
            "water" -> R.drawable.ic_type_water
            else -> R.drawable.ic_pokeball_splash
        }
}