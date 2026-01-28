package com.example.pokedex.presentation.screens.pokedex.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex.utils.animationShimmerItem

@Composable
fun PokemonItemShimmer() {
    /*Card(
        modifier = Modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = MaterialTheme.colorScheme.onBackground
        ),
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(Color.Transparent)
                .padding(4.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .weight(1F),
                )

                Box{}
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.2f)
                    .fillMaxHeight(),
            )
        }
    }*/

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(Color.Transparent)
            .clip(MaterialTheme.shapes.large)
            .animationShimmerItem(isLoading = true)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(0.8F)
                    .height(22.dp)
                    .padding(all = 2.dp)
                    .animationShimmerItem(isLoading = true),
            )

            Box(
                modifier = Modifier
                    .weight(0.2F)
                    .height(16.dp)
                    .padding(all = 2.dp)
                    .animationShimmerItem(isLoading = true),
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.2f)
                .fillMaxHeight()
                .padding(all = 2.dp)
                .animationShimmerItem(isLoading = true),
        )
    }
}