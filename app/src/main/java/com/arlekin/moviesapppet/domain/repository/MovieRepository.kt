package com.arlekin.moviesapppet.domain.repository

import com.arlekin.moviesapppet.domain.model.Movie
import com.arlekin.moviesapppet.util.Resource

interface MovieRepository {

    suspend fun getMovies(): Resource<List<Movie>>

    suspend fun addFavorite(movie: Movie)

    suspend fun removeFavorite(movieId: Int)

    suspend fun getFavorites(): List<Movie>
}
