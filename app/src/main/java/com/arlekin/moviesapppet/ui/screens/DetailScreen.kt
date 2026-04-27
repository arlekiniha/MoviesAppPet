package com.arlekin.moviesapppet.ui.screens

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailScreen(movieId: Int) {
    Text(
        text = "Movie ID: $movieId",
        style = MaterialTheme.typography.headlineMedium
    )
}
