package com.arlekin.moviesapppet.ui.screens

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.arlekin.moviesapppet.data.model.Movie
import com.arlekin.moviesapppet.ui.elements.MovieCard
import com.arlekin.moviesapppet.ui.viewModels.MovieState
import com.arlekin.moviesapppet.ui.viewModels.MovieViewModel

@Composable
fun MainScreen(
    viewModel: MovieViewModel
) {
    val state by viewModel.state.collectAsState()
    var selectedMovie by remember { mutableStateOf<Movie?>(null) }

    when (val currentState = state) {
        is MovieState.Loading -> CircularProgressIndicator()
        is MovieState.Success -> {
            if (selectedMovie == null) {
                LazyColumn {
                    items(currentState.movies) { movie ->
                        MovieCard(
                            movie.title,
                            movie.description,
                            { selectedMovie = movie })
                    }
                }
            } else {
                selectedMovie?.let { movie ->
                    DetailScreen(movie = movie)
                }
            }
        }
        is MovieState.Error -> Text("Error")
    }
}

