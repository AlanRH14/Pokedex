package com.example.pokedex.data.local

import androidx.room.TypeConverter
import com.example.pokedex.domain.models.Sprites
import com.example.pokedex.domain.models.Stat
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

class DatabaseConverter {
    private val json = Json { ignoreUnknownKeys = true }

    @TypeConverter
    fun converterSpritesToString(sprites: Sprites?): String {
        return if (sprites == null) "" else json.encodeToString(Sprites.serializer(), sprites)
    }

    @TypeConverter
    fun converterStringToSprints(sprites: String): Sprites {
        return if (sprites.isEmpty())
            Sprites()
        else
            json.decodeFromString(Sprites.serializer(), sprites)
    }

    @TypeConverter
    fun converterTypesToString(types: List<String>?): String {
        return if (types.isNullOrEmpty()) "" else json.encodeToString(types)
    }

    @TypeConverter
    fun converterStringToTypes(types: String): List<String> {
        return if (types.isEmpty()) emptyList() else json.decodeFromString(types)
    }

    @TypeConverter
    fun converterStatsToString(stats: List<Stat>?): String {
        return if (stats.isNullOrEmpty())
            ""
        else
            json.encodeToString(ListSerializer(Stat.serializer()), stats)
    }

    @TypeConverter
    fun convertER

}