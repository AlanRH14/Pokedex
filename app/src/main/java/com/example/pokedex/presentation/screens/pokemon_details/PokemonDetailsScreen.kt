package com.example.pokedex.presentation.screens.pokemon_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.pokedex.R
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailsScreen(
    modifier: Modifier = Modifier,
    pokemonName: String,
    viewModel: PokemonDetailViewModel = koinViewModel(),
    navController: NavHostController,
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = pokemonName) {
        viewModel.onEvent(PokemonDetailUIEvent.OnGetPokemonDetail(pokemonName = pokemonName))
    }

    LaunchedEffect(key1 = true) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                is PokemonDetailEffect.NavigateToBack -> navController.popBackStack()
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box {
            val imageRequest = ImageRequest.Builder(LocalContext.current)
                .data(state.pokemonDetail?.url ?: "")
                .crossfade(true)
                .build()

            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                model = imageRequest,
                contentScale = ContentScale.Fit,
                contentDescription = "Image ${state.pokemonDetail?.name ?: pokemonName}",
            )

            TopAppBar(
                modifier = Modifier
                    .align(Alignment.TopCenter),
                title = {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .alpha(8F),
                        text = state.pokemonDetail?.name ?: "Pokemon Empty",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        ),
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = stringResource(R.string.icon_back)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                ),
                actions = {
                    IconToggleButton(
                        checked = state.isFavorite,
                        onCheckedChange = {
                            viewModel.onEvent(PokemonDetailUIEvent.OnClickedToggleFavorite)
                        }
                    ) {
                        Icon(
                            painter = if (state.isFavorite)
                                painterResource(R.drawable.ic_favorite)
                            else
                                painterResource(R.drawable.ic_favorite_border),
                            tint = if (state.isFavorite)
                                Color.Red
                            else
                                Color.LightGray,
                            contentDescription = stringResource(R.string.icon_toggle_favorite),
                        )
                    }
                }
            )
        }

        if (!state.errorMessage.isNullOrEmpty()) {
            Text(text = state.errorMessage ?: "Unknown")
        }
    }
}