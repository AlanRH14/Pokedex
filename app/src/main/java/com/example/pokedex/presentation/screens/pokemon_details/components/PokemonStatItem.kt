package com.example.pokedex.presentation.screens.pokemon_details.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pokedex.domain.models.Stat
import com.example.pokedex.ui.theme.Green300
import com.example.pokedex.ui.theme.Red400
import com.example.pokedex.ui.theme.Yellow400
import kotlin.math.roundToInt

@Composable
fun PokemonStatItem(stat: Stat) {
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
        modifier = Modifier.padding(all = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Text(
            modifier = Modifier.weight(.3F),
            text = stat.name,
            color = MaterialTheme.colorScheme.outline.copy(0.8F),
            style = MaterialTheme.typography.bodyLarge
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

        val progressColor = when {
            progress <= 0.2F -> Red400
            progress <= 0.5F -> Yellow400
            progress >= 0.6F -> Green300
            else -> Green300
        }
        val progressTrackColor = MaterialTheme.colorScheme.outline.copy(0.2F)

        Box(
            modifier = Modifier
                .weight(0.5F)
                .height(10.dp)
                .drawBehind {
                    drawRoundRect(
                        color = progressTrackColor,
                        topLeft = Offset.Zero,
                        size = size,
                        cornerRadius = CornerRadius(size.height, size.height)
                    )

                    drawRoundRect(
                        color = progressColor,
                        topLeft = Offset.Zero,
                        size = Size(width = size.width * animatedProgress, height = size.height),
                        cornerRadius = CornerRadius(size.height, size.height)
                    )
                }
        )
    }
}