package com.example.pokedex.presentation.screens.pokemon_details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.domain.repository.PokemonDetailRepository
import com.example.pokedex.domain.repository.PokemonPaletteRepository
import com.example.pokedex.navigation.TabsNavRoute
import com.example.pokedex.presentation.screens.pokemon_details.mvi.PokemonDetailEffect
import com.example.pokedex.presentation.screens.pokemon_details.mvi.PokemonDetailState
import com.example.pokedex.presentation.screens.pokemon_details.mvi.PokemonDetailUIEvent
import com.example.pokedex.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokemonDetailViewModel(
    private val pokemonDetailRepository: PokemonDetailRepository,
    private val pokemonPaletteRepository: PokemonPaletteRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(PokemonDetailState())
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<PokemonDetailEffect>()
    val effect = _effect.asSharedFlow()

    fun onEvent(event: PokemonDetailUIEvent) {
        when (event) {
            is PokemonDetailUIEvent.OnGetPokemonDetail -> getPokemonDetail(pokemonName = event.pokemonName)
            is PokemonDetailUIEvent.OnGetPokemonSpecies -> getPokemonSpecies(species = event.species)
            is PokemonDetailUIEvent.OnClickedToggleFavorite -> changeToggleFavoriteState()
            is PokemonDetailUIEvent.OnClickedBack -> navigateToBack()
            is PokemonDetailUIEvent.OnClickTabNavigation -> navigateToTabs(route = event.route)
            is PokemonDetailUIEvent.OnGetPokemonType -> getPokemonType(pokemonID = event.pokemonID)
        }
    }

    private fun getPokemonDetail(pokemonName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            pokemonDetailRepository.fetchPokemonDetail(name = pokemonName).collect { result ->
                when (result) {
                    is Resource.Loading -> _state.update { it.copy(isLoading = true) }

                    is Resource.Success -> _state.update {
                        val pokemon =
                            pokemonPaletteRepository.generatePokemonPalette(result.data.url)
                        it.copy(
                            pokemonDetail = result.data.copy(colorPalette = pokemon),
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

    private fun getPokemonSpecies(species: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val species = species.drop(1).toInt().toString()
            pokemonDetailRepository.fetchPokemonSpecies(species = species).collect { result ->
                when (result) {
                    is Resource.Loading -> _state.update { it.copy(isLoading = true) }

                    is Resource.Success -> {
                        _state.update {
                            it.copy(
                                isLoading = false, pokemonDetail = it.pokemonDetail?.copy(
                                    species = result.data
                                )
                            )
                        }
                    }

                    is Resource.Error -> _state.update { it.copy(errorMessage = result.message) }
                }
            }
        }
    }

    private fun getPokemonType(pokemonID: String) {
        viewModelScope.launch(Dispatchers.IO) {
            pokemonDetailRepository.fetchPokemonType(type = pokemonID).collect { result ->
                when (result) {
                    is Resource.Loading -> _state.update { it.copy(isLoading = true) }

                    is Resource.Success -> _state.update {
                        Log.d("LordMiau", "Result: ${result.data}")
                        it.copy(isLoading = false)
                    }

                    is Resource.Error -> _state.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = result.message
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

    private fun navigateToTabs(route: TabsNavRoute) {
        viewModelScope.launch {
            _effect.emit(PokemonDetailEffect.NavigateToTabs(route = route))
        }
    }
}