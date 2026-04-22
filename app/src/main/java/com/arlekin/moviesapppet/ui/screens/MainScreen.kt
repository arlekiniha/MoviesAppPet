package com.arlekin.moviesapppet.ui.screens

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.arlekin.moviesapppet.data.model.Movie
import com.arlekin.moviesapppet.ui.elements.MovieCard
import com.arlekin.moviesapppet.ui.viewModels.MovieViewModel

@Composable
fun MainScreen(
    viewModel: MovieViewModel
) {
    val movies = viewModel.getMovies()

    var selectedMovie by remember { mutableStateOf<Movie?>(null) }

    if (selectedMovie == null) {
        LazyColumn {
            items(movies) { movie ->
                MovieCard(movie.title, movie.description, {selectedMovie = movie})
            }
        }
    } else {
        DetailScreen(movie = selectedMovie!!)
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    val fakeViewModel = MovieViewModel()
    MainScreen(fakeViewModel)
}