package com.arlekin.moviesapppet.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.arlekin.moviesapppet.ui.elements.MovieCard
import com.arlekin.moviesapppet.ui.viewModels.MovieViewModel

@Composable
fun MainScreen(
    viewModel: MovieViewModel
) {
    val movies = viewModel.getMovies()

    LazyColumn {
        items(movies) { movie ->
            MovieCard(movie.title, movie.description)
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    val fakeViewModel = MovieViewModel()
    MainScreen(fakeViewModel)
}