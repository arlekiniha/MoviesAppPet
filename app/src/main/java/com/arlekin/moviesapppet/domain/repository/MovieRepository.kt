package com.arlekin.moviesapppet.domain.repository

import com.arlekin.moviesapppet.domain.model.Movie
import com.arlekin.moviesapppet.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    val movies: Flow<List<Movie>>
    val favoritesMovies: Flow<List<Movie>>

    suspend fun fetchMovies(): Resource<Unit>

    suspend fun updateIsFavorite(movieId: Int, isFavorite: Boolean)

    suspend fun removeFavorite(movieId: Int)

}
