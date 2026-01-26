package com.example.pokedex.presentation.components

import androidx.compose.runtime.Composable
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.pokedex.domain.models.Pokemon

@Composable
fun HandlerPagingResult(
    pokemons: LazyPagingItems<Pokemon>,
): Boolean {
    pokemons.apply {
        val error = when {
            loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
            loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
            loadState.append is LoadState.Error -> loadState.append as LoadState.Error
            else -> null
        }

        return when {
            loadState.refresh is LoadState.Loading -> {
                false
            }

            error != null -> {
                false
            }

            pokemons.itemCount < 1 -> {
                false
            }

            else -> true
        }
    }
}
