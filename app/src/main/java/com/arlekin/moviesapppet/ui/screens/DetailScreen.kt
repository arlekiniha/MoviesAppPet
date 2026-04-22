package com.arlekin.moviesapppet.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.arlekin.moviesapppet.data.model.Movie
import com.arlekin.moviesapppet.ui.viewModels.MovieViewModel

@Composable
fun DetailScreen(
    movie: Movie,
    modifier: Modifier = Modifier
) {
    Column {
        Spacer(Modifier.height(12.dp))
        Text(movie.title)
        Spacer(Modifier.height(8.dp))
        Text(movie.description)
        Spacer(Modifier.height(8.dp))
    }
}