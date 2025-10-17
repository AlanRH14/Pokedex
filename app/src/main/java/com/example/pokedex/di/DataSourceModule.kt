package com.example.pokedex.di

import com.example.pokedex.data.remote.ImageRemoteDataSource
import com.example.pokedex.data.repository.BitmapFromURLDataSourceImpl
import org.koin.dsl.module


val dataSourceModule = module {
    single<ImageRemoteDataSource> { BitmapFromURLDataSourceImpl() }

}