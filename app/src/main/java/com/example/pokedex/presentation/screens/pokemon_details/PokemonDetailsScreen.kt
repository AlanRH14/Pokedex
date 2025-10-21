package com.example.pokedex.presentation.screens.pokemon_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.presentation.components.PokemonImage
import com.example.pokedex.presentation.screens.pokemon_details.components.PokemonTabsInfo
import com.example.pokedex.presentation.screens.pokemon_details.mvi.PokemonDetailEffect
import com.example.pokedex.presentation.screens.pokemon_details.mvi.PokemonDetailUIEvent
import com.example.pokedex.presentation.screens.pokemon_details.widgets.PokemonDetailTopBar
import com.example.pokedex.presentation.screens.pokemon_details.widgets.PokemonInfo
import com.example.pokedex.presentation.screens.pokemon_details.widgets.PokemonTypes
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@Composable
fun PokemonDetailsScreen(
    pokemonName: String,
    viewModel: PokemonDetailViewModel = koinViewModel(),
    navController: NavHostController,
) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    val tabsNavController = rememberNavController()

    LaunchedEffect(key1 = pokemonName) {
        viewModel.onEvent(PokemonDetailUIEvent.OnGetPokemonDetail(pokemonName = pokemonName))
    }

    LaunchedEffect(key1 = true) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                is PokemonDetailEffect.NavigateToBack -> navController.popBackStack()
                is PokemonDetailEffect.NavigateToTabs -> tabsNavController.navigate(route = effect.route)
            }
        }
    }

    Box(contentAlignment = Alignment.TopCenter) {
        PokemonImage(
            modifier = Modifier
                .widthIn(max = 800.dp)
                .fillMaxWidth(.9f)
                .wrapContentHeight(Alignment.Top, true)
                .scale(1f, 1.8f)
                .blur(70.dp, BlurredEdgeTreatment.Unbounded)
                .alpha(.5f),
            image = state.pokemonDetail?.url ?: "",
            contentScale = ContentScale.FillWidth,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(3f) }),
            contentDescription = "Image ${state.pokemonDetail?.name ?: pokemonName}",
        )

        Scaffold(
            topBar = {
                PokemonDetailTopBar(
                    title = state.pokemonDetail?.name ?: "Pokemon Empty",
                    isFavorite = state.isFavorite,
                    onEvent = viewModel::onEvent,
                )
            },
            containerColor = Color.Transparent
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    modifier = Modifier,
                ) {
                    PokemonImage(
                        modifier = Modifier
                            .widthIn(max = 500.dp)
                            .fillMaxWidth()
                            .aspectRatio(1.2f)
                            .fillMaxHeight(),
                        image = state.pokemonDetail?.url ?: "",
                        contentDescription = "Image ${state.pokemonDetail?.name ?: pokemonName}",
                        contentScale = ContentScale.Fit,
                    )
                }

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .alpha(0.5F)
                        .padding(bottom = 8.dp),
                    text = state.pokemonDetail?.id ?: "Unknown",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                )

                PokemonTypes(
                    modifier = Modifier.padding(8.dp),
                    types = state.pokemonDetail?.types ?: emptyList(),
                    color = state.pokemonDetail?.colorPalette?.domainColor ?: Color.White.hashCode()
                )

                Spacer(modifier = Modifier.height(16.dp))

                PokemonInfo(
                    weight = state.pokemonDetail?.weight ?: 0F,
                    height = state.pokemonDetail?.height ?: 0F,
                )

                Spacer(modifier = Modifier.height(32.dp))

                PokemonTabsInfo(
                    modifier = Modifier.fillMaxSize(),
                    navController = tabsNavController,
                    pokemonDetail = state.pokemonDetail,
                    onEvent = viewModel::onEvent
                )
            }
        }
    }
}
