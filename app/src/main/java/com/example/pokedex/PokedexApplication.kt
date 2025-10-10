package com.example.pokedex

import android.app.Application
import com.example.pokedex.di.apiMapperModule
import com.example.pokedex.di.databaseModule
import com.example.pokedex.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class PokedexApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PokedexApplication)
            androidLogger(Level.DEBUG)
            modules(
                networkModule,
                databaseModule,
                apiMapperModule
            )
        }
    }
}