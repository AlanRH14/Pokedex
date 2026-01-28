package com.example.pokedex.presentation.screens.pokedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonPaletteColors
import com.example.pokedex.domain.repository.MainRepository
import com.example.pokedex.domain.repository.PokemonPaletteRepository
import com.example.pokedex.presentation.screens.pokedex.mvi.PokemonEffect
import com.example.pokedex.presentation.screens.pokedex.mvi.PokemonState
import com.example.pokedex.presentation.screens.pokedex.mvi.PokemonUIEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit

class PokedexViewModel(
    private val pokemonRepository: MainRepository,
    private val pokemonPaletteRepository: PokemonPaletteRepository
) : ViewModel() {

    private val _state = MutableStateFlow(PokemonState())
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<PokemonEffect>()
    val effect = _effect.asSharedFlow()

    private val paletteSemaphore = Semaphore(4)

    fun onEvent(event: PokemonUIEvent) {
        when (event) {
            is PokemonUIEvent.OnGetPokemonList -> getPokemons()
            is PokemonUIEvent.OnClickPokemonDetail -> navigateToPokemonDetail(pokemonName = event.pokemonName)
            is PokemonUIEvent.OnPokemonItemVisible -> onPokemonVisible(pokemon = event.pokemon)
        }
    }

    private fun getPokemons() {
        /*viewModelScope.launch(Dispatchers.IO) {
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
        }*/

        val pokemonPagingFlow = pokemonRepository.fetchPokemonList().cachedIn(viewModelScope)
        _state.update { it.copy(pokemonList = pokemonPagingFlow) }
    }

    private suspend fun loadPaletteForPokemon(pokemon: Pokemon) {
        paletteSemaphore.withPermit {
            try {
                val palette = pokemonPaletteRepository.generatePokemonPalette(pokemon.url)
                if (palette != null) {
                    updatePokemonPalette(pokemon= pokemon.name, palette = palette)
                }
            } catch (e: Exception) {
                print("Error: $pokemon ${e.message}")
            }
        }
    }

    private fun updatePokemonPalette(pokemon: String, palette: PokemonPaletteColors) {
        _state.update {
            it.copy(
                pokemonPalettes = it.pokemonPalettes + (pokemon to palette)
            )
        }
    }

    private fun onPokemonVisible(pokemon: Pokemon) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isLoading = false) }
            if (pokemon.colorPalette == null) {
                loadPaletteForPokemon(pokemon)
            }
        }
    }

    private fun navigateToPokemonDetail(pokemonName: String) {
        viewModelScope.launch {
            _effect.emit(PokemonEffect.NavigateToPokemonDetail(pokemonName = pokemonName))
        }
    }
}