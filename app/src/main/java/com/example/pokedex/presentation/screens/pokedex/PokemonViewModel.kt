package com.example.pokedex.presentation.screens.pokedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.domain.repository.MainRepository
import com.example.pokedex.presentation.screens.pokedex.mvi.PokemonEffect
import com.example.pokedex.presentation.screens.pokedex.mvi.PokemonState
import com.example.pokedex.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokemonViewModel(
    private val pokemonRepository: MainRepository
) : ViewModel() {

    private val _state = MutableStateFlow(PokemonState())
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<PokemonEffect>()
    val effect = _effect.asSharedFlow()

    fun onEvent(event: PokemonUIEvent) {
        when (event) {
            is PokemonUIEvent.OnGetPokemonList -> getPokemons()

            is PokemonUIEvent.OnClickPokemonDetail -> navigateToPokemonDetail(pokemonName = event.pokemonName)
        }
    }

    private fun getPokemons() {
        viewModelScope.launch(Dispatchers.IO) {
            pokemonRepository.fetchPokemonList().collect { result ->
                when (result) {
                    is Resource.Loading -> _state.update { it.copy(isLoading = true) }

                    is Resource.Success -> _state.update {
                        it.copy(
                            pokemonList = result.data,
                            isLoading = false
                        )
                    }

                    is Resource.Error -> _state.update {
                        it.copy(
                            errorMessage = result.message,
                            isLoading = false
                        )
                    }
                }
            }
        }
    }

    private fun navigateToPokemonDetail(pokemonName: String) {
        viewModelScope.launch {
            _effect.emit(PokemonEffect.NavigateToPokemonDetail(pokemonName = pokemonName))
        }
    }
}