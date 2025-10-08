package com.example.pokedex.utils

sealed interface Resource<out T> {
    data class Success<T>(val data: T): Resource<T>
}
