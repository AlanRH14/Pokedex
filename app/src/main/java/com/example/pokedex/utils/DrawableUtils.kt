package com.example.pokedex.utils

import androidx.annotation.DrawableRes
import com.example.pokedex.R

object DrawableUtils {
    val String.icon : Int @DrawableRes get() =
        when (this) {
            "Bug" -> R.drawable.ic_type_bug
            "Dark" -> R.drawable.ic_type_dark
            "Dragon" -> R.drawable.ic_type_dragon
            "Electric" -> R.drawable.ic_type_electric
            "Fairy" -> R.drawable.ic_type_fairy
            "Fighting" -> R.drawable.ic_type_fighting
            "Fire" -> R.drawable.ic_type_fire
            "Flying" -> R.drawable.ic_type_flying
            "Ghost" -> R.drawable.ic_type_ghost
            "Grass" -> R.drawable.ic_type_grass
            "Ground" -> R.drawable.ic_type_ground
            "Ice" -> R.drawable.ic_type_ice
            "Normal" -> R.drawable.ic_type_normal
            "Poison" -> R.drawable.ic_type_poison
            "Psychic" -> R.drawable.ic_type_psychic
            "Rock" -> R.drawable.ic_type_rock
            "Steel" -> R.drawable.ic_type_steel
            "Water" -> R.drawable.ic_type_water
            else -> R.drawable.ic_arrow_back
        }
}