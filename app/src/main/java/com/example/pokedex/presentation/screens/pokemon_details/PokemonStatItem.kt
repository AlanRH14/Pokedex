package com.example.pokedex.presentation.screens.pokemon_details

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.pokedex.domain.models.Stat
import com.example.pokedex.ui.theme.Green300
import com.example.pokedex.ui.theme.Red400
import com.example.pokedex.ui.theme.Yellow400
import kotlin.math.roundToInt

@Composable
fun PokemonStatItem(
    modifier: Modifier = Modifier,
    stat: Stat
) {

    val animationProgress = remember {
        Animatable(initialValue = 0F)
    }

    LaunchedEffect(key1 = Unit) {
        animationProgress.animateTo(
            targetValue = 1F,
            animationSpec = tween(
                durationMillis = 8 * stat.baseStat,
                easing = LinearEasing
            )
        )
    }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Text(
            modifier = Modifier.weight(.3F),
            text = stat.stat,
            color = MaterialTheme.colorScheme.outline.copy(0.8F),
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Bold
            )
        )

        Text(
            modifier = Modifier.weight(.2F),
            text = "${(stat.baseStat * animationProgress.value).roundToInt()}",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Bold
            )
        )

        val progress = stat.baseStat.toFloat() / stat.maxValue.toFloat()
        val animatedProgress = progress * animationProgress.value

        val progressColor = when (progress) {
            in 0.0 .. 0.2 -> Red400

            in 0.2 .. 0.5 -> Yellow400

            else -> Green300
        }
        val progressTrackColor = MaterialTheme.colorScheme.outline.copy(0.2F)
    }
}