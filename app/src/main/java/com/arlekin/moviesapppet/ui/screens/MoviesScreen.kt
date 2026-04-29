package com.arlekin.moviesapppet.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.arlekin.moviesapppet.ui.viewModels.MovieState
import com.arlekin.moviesapppet.ui.viewModels.MovieViewModel
import com.arlekin.moviesapppet.ui.elements.MovieItem
import com.arlekin.moviesapppet.ui.models.MovieUi

@Composable
fun MoviesScreen(
    viewModel: MovieViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadMovies()
    }
    Column {
        when (state) {
            is MovieState.Loading -> LoadingView()
            is MovieState.Error -> ErrorView()
            is MovieState.Success -> {
                val movies = (state as MovieState.Success).movies
                MoviesList(
                    movies = movies,
                    onFavoriteClick = viewModel::onFavoriteClick
                )
            }
        }
    }
}


@Composable
fun LoadingView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Loading error")
    }
}

@Composable
fun MoviesList(
    movies: List<MovieUi>,
    onFavoriteClick: (movieId: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp)
    ) {
        items(movies) { movie ->
            MovieItem(
                movie = movie,
                isFavorite = movie.isFavorite,
                onFavoriteClick = onFavoriteClick,
            )
        }
    }
}



