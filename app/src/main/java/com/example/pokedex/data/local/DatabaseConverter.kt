package com.example.pokedex.data.local

import androidx.room.TypeConverter
import com.example.pokedex.domain.models.Sprites
import kotlinx.serialization.json.Json

class DatabaseConverter {
    private val json = Json { ignoreUnknownKeys = true }

    @TypeConverter
    fun convertSpritesToString(sprites: Sprites?): String {
        return if (sprites == null) "" else json.encodeToString(Sprites.serializer(), sprites)
    }

    @TypeConverter
    fun converterStringToSprints(sprites: String): Sprites {
        return if (sprites.isEmpty()) Sprites()
        else json.decodeFromString(Sprites.serializer(), sprites)
    }

    @TypeConverter
    fun converterTypesToString(types: List<PokemonType>): String {
        return if (types.isEmpty()) "" else json.encodeToString(types.sera)
    }
}