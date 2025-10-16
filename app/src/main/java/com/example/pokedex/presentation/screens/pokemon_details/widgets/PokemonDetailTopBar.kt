package com.example.pokedex.presentation.screens.pokemon_details.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.pokedex.R
import com.example.pokedex.presentation.screens.pokemon_details.mvi.PokemonDetailUIEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailTopBar(
    title: String,
    isFavorite: Boolean,
    onEvent: (PokemonDetailUIEvent) -> Unit
) {
    TopAppBar(
        title = {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .alpha(8F),
                text = title,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
            )
        },
        navigationIcon = {
            IconButton(
                onClick = { onEvent(PokemonDetailUIEvent.OnClickedBack) }
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_back),
                    contentDescription = stringResource(R.string.icon_back)
                )
            }
        },
        actions = {
            IconToggleButton(
                checked = isFavorite,
                onCheckedChange = {
                    onEvent(PokemonDetailUIEvent.OnClickedToggleFavorite)
                }
            ) {
                Icon(
                    painter = if (isFavorite)
                        painterResource(R.drawable.ic_favorite)
                    else
                        painterResource(R.drawable.ic_favorite_border),
                    tint = if (isFavorite)
                        Color.Red
                    else
                        Color.LightGray,
                    contentDescription = stringResource(R.string.icon_toggle_favorite),
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
    )
}