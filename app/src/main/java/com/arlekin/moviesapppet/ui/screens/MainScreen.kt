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
import androidx.navigation.NavController
import com.arlekin.moviesapppet.data.model.Movie
import com.arlekin.moviesapppet.ui.elements.MovieCard
import com.arlekin.moviesapppet.ui.viewModels.MovieState
import com.arlekin.moviesapppet.ui.viewModels.MovieViewModel

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MovieViewModel = MovieViewModel()
) {
    val state by viewModel.state.collectAsState()

    when (val currentState = state) {
        is MovieState.Loading -> CircularProgressIndicator()
        is MovieState.Success -> {
            LazyColumn {
                items(currentState.movies) { movie ->
                    MovieCard(
                        movie = movie,
                        onClick = {
                            navController.navigate("details/${movie.id}")
                        }
                    )
                }
            }
        }
        is MovieState.Error -> Text("Error")
    }
}


