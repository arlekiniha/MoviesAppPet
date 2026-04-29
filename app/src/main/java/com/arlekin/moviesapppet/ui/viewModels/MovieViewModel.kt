package com.arlekin.moviesapppet.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arlekin.moviesapppet.domain.model.Movie
import com.arlekin.moviesapppet.domain.usecase.AddFavouriteUseCase
import com.arlekin.moviesapppet.domain.usecase.GetFavoriteUseCase
import com.arlekin.moviesapppet.domain.usecase.GetMoviesUseCase
import com.arlekin.moviesapppet.domain.usecase.RemoveFavoriteUseCase
import com.arlekin.moviesapppet.util.DomainError
import com.arlekin.moviesapppet.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class MovieState {
    object Loading : MovieState()
    data class Success(val movies: List<Movie>) : MovieState()
    data class Error(val message: String) : MovieState()
}

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val addFavoriteUseCase: AddFavouriteUseCase,
    private val removeFavoriteUseCase: RemoveFavoriteUseCase,
    private val getFavoritesUseCase: GetFavoriteUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<MovieState>(MovieState.Loading)
    val state: StateFlow<MovieState> = _state

    private val _favorites = MutableStateFlow<List<Movie>>(emptyList())
    val favorites: StateFlow<List<Movie>> = _favorites

    init {
        loadMovies()
        loadFavorites()
    }

    fun loadMovies() {
        viewModelScope.launch {
            _state.value = MovieState.Loading

            when (val result = getMoviesUseCase()) {
                is Resource.Success -> {
                    _state.value = MovieState.Success(result.data)
                }
                is Resource.Failure -> {
                    _state.value = MovieState.Error(result.error.toUi())
                }

                else -> {}
            }
        }
    }

    fun loadFavorites() {
        viewModelScope.launch {
            _favorites.value = getFavoritesUseCase()
        }
    }

    fun addFavorite(movie: Movie) {
        viewModelScope.launch {
            addFavoriteUseCase(movie)
            loadFavorites()
        }
    }

    fun removeFavorite(id: Int) {
        viewModelScope.launch {
            removeFavoriteUseCase(id)
            loadFavorites()
        }
    }
}

fun DomainError?.toUi(): String {
    return when(this){
        DomainError.RemoteError -> "Server Error"
        DomainError.LocalError -> "Local Error"
        else -> "Unknown Error"
    }
}