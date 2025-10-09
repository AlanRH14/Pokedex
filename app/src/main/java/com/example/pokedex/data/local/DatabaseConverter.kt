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
        return if (sprites == null) "null" else json.encodeToString(Sprites.serializer(), sprites)
    }

    @TypeConverter
    fun converterStringToSprints(sprites: String): Sprites? {
        return if (sprites == "null")
            null
        else
            json.decodeFromString(Sprites.serializer(), sprites)
    }

    @TypeConverter
    fun converterListStrToString(types: List<String>?): String {
        return if (types.isNullOrEmpty()) "[]" else json.encodeToString(types)
    }

    @TypeConverter
    fun converterStringToListStr(types: String): List<String> {
        return if (types.isBlank() || types == "[]") emptyList() else json.decodeFromString(types)
    }

    @TypeConverter
    fun converterStatsToString(stats: List<Stat>?): String {
        return if (stats.isNullOrEmpty())
            "[]"
        else
            json.encodeToString(ListSerializer(Stat.serializer()), stats)
    }

    @TypeConverter
    fun converterStringToStats(stats: String): List<Stat> {
        return if(stats.isBlank() || stats == "[]") emptyList()
        else json.decodeFromString(ListSerializer(Stat.serializer()),stats)
    }
}