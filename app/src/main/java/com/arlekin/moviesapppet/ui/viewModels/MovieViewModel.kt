package com.arlekin.moviesapppet.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arlekin.moviesapppet.data.model.Movie
import com.arlekin.moviesapppet.data.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class MovieState {
    object Loading : MovieState()
    data class Success(val movies: List<Movie>) : MovieState()
    data class Error(val message: String) : MovieState()
}

class MovieViewModel : ViewModel() {

    private val repository = MovieRepository()

    private val _state = MutableStateFlow<MovieState>(MovieState.Loading)
    val state: StateFlow<MovieState> = _state

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            try {
                val movies = repository.getMovies()
                _state.value = MovieState.Success(movies)
            } catch (e: Exception) {
                _state.value = MovieState.Error("Error")
            }
        }
    }
}