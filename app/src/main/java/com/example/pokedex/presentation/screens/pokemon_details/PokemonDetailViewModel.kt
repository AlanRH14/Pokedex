package com.example.pokedex.presentation.screens.pokemon_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.domain.repository.PokemonDetailRepository
import com.example.pokedex.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokemonDetailViewModel(
    private val pokemonDetailRepository: PokemonDetailRepository
) : ViewModel() {

    private val _state = MutableStateFlow(PokemonDetailState())
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<PokemonDetailEffect>()
    val effect = _effect.asSharedFlow()

    fun onEvent(event: PokemonDetailUIEvent) {
        when (event) {
            is PokemonDetailUIEvent.OnGetPokemonDetail -> getPokemonDetail(pokemonName = event.pokemonName)
            is PokemonDetailUIEvent.OnClickedToggleFavorite -> changeToggleFavoriteState()
            is PokemonDetailUIEvent.OnClickedBack -> navigateToBack()
        }
    }

    private fun getPokemonDetail(pokemonName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            pokemonDetailRepository.fetchPokemonDetail(name = pokemonName).collect { result ->
                when (result) {
                    is Resource.Loading -> _state.update { it.copy(isLoading = true) }

                    is Resource.Success -> _state.update {
                        it.copy(
                            pokemonDetail = result.data,
                            isLoading = false,
                        )
                    }

                    is Resource.Error -> _state.update {
                        it.copy(
                            errorMessage = result.message,
                            pokemonDetail = null,
                            isLoading = false
                        )
                    }
                }
            }
        }
    }

    private fun changeToggleFavoriteState() {
        _state.update { it.copy(isFavorite = !it.isFavorite) }
    }

    private fun navigateToBack() {
        viewModelScope.launch { _effect.emit(PokemonDetailEffect.NavigateToBack) }
    }
}