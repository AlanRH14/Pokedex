package com.example.pokedex.di

import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
}