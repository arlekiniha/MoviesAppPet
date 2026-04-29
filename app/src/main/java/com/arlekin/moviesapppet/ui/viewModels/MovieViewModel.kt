package com.arlekin.moviesapppet.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arlekin.moviesapppet.domain.model.Movie
import com.arlekin.moviesapppet.domain.repository.MovieRepository
import com.arlekin.moviesapppet.domain.usecase.AddFavouriteUseCase
import com.arlekin.moviesapppet.domain.usecase.GetFavoriteUseCase
import com.arlekin.moviesapppet.domain.usecase.GetMoviesUseCase
import com.arlekin.moviesapppet.domain.usecase.RemoveFavoriteUseCase
import com.arlekin.moviesapppet.ui.models.MovieUi
import com.arlekin.moviesapppet.util.DomainError
import com.arlekin.moviesapppet.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.collections.any

sealed class MovieState {
    object Loading : MovieState()
    data class Success(val movies: List<MovieUi>) : MovieState()
    data class Error(val message: String) : MovieState()
}

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val addFavoriteUseCase: AddFavouriteUseCase,
    private val removeFavoriteUseCase: RemoveFavoriteUseCase,
    private val getFavoritesUseCase: GetFavoriteUseCase,
    private val repository: MovieRepository, // todo extract to use case
) : ViewModel() {

    private val _state = MutableStateFlow<MovieState>(MovieState.Loading)
    val state: StateFlow<MovieState> = _state

    private val _favorites = MutableStateFlow<List<MovieUi>>(emptyList())
    val favorites: StateFlow<List<MovieUi>> = _favorites.asStateFlow()

//    init {
//        loadMovies()
//        loadFavorites()
//    }

    fun loadMovies() {
        viewModelScope.launch {
            _state.value = MovieState.Loading

            when (val result = getMoviesUseCase()) {
                is Resource.Success -> {
                    // todo
                }

                is Resource.Failure -> {
                    _state.value = MovieState.Error(result.error.toUi())
                }

                else -> {}
            }
        }
        repository.movies.onEach { movies ->
            _state.value = MovieState.Success(movies.map { it.toUi() })
        }.launchIn(viewModelScope)

    }


    fun loadFavorites() {
        viewModelScope.launch {
            getFavoritesUseCase().collect { movies ->
                _favorites.value = movies.map { it.toUi() }
            }
        }
    }

    fun addFavorite(movieId: Int) {
        viewModelScope.launch {
            addFavoriteUseCase(movieId)
        }
    }

    fun onFavoriteClick(movieId: Int) {
        if (favorites.value.any { it.id == movieId }) {
            removeFavorite(movieId)
        } else {
            addFavorite(movieId)
        }
    }

    fun removeFavorite(id: Int) {
        viewModelScope.launch {
            removeFavoriteUseCase(id)
        }
    }
}

fun DomainError?.toUi(): String {
    return when (this) {
        DomainError.RemoteError -> "Server Error"
        DomainError.LocalError -> "Local Error"
        else -> "Unknown Error"
    }
}

fun MovieUi.toDomain(): Movie {
    return Movie(
        id = id,
        title = title,
        description = description,
        posterUrl = posterUrl,
        rating = rating,
        isFavorite = isFavorite
    )
}

fun Movie.toUi(): MovieUi {
    return MovieUi(
        id = id,
        title = title,
        description = description,
        posterUrl = posterUrl,
        rating = rating,
        isFavorite = isFavorite
    )
}