package com.example.pokedex.presentation

import androidx.lifecycle.ViewModel
import com.example.pokedex.domain.repository.MainRepository

class PokemonViewModel(
    private val pokemonRepository: MainRepository
): ViewModel() {


}