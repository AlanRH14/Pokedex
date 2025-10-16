package com.example.pokedex.data.repository

import android.graphics.BitmapFactory
import coil3.Bitmap
import com.example.pokedex.data.remote.ImageRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

class GenerateBitmapFromURLImpl : ImageRemoteDataSource {

    override suspend fun generatePaletteFromURL(pokemonURL: String): Bitmap? =
        withContext(Dispatchers.IO) {
            try {
                val url = URL(pokemonURL)
                val connection = url.openConnection() as HttpURLConnection
                connection.connectTimeout = 15_000
                connection.readTimeout = 15_000
                connection.doInput = true

                if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                    BitmapFactory.decodeStream(connection.inputStream)
                } else {
                    null
                }
            } catch (e: Exception) {
                print("Error: $e")
                null
            }
        }
}