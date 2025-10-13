package com.example.pokedex.presentation

import androidx.lifecycle.ViewModel
import com.example.pokedex.domain.repository.MainRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

class PokemonViewModel(
    private val pokemonRepository: MainRepository
): ViewModel() {

    private val _state = MutableStateFlow(PokemonState())
    val  state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<PokemonEffect>()
    val effect = _effect.asSharedFlow()

    fun onEvent(event: PokemonUIEvent) {
        when (event) {
            is PokemonUIEvent.OnGetPokemonList -> Unit

            is PokemonUIEvent.OnClickPokemonDetail -> Unit
        }
    }
}