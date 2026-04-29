package com.arlekin.moviesapppet.data.repository

import com.arlekin.moviesapppet.domain.model.Movie
import com.arlekin.moviesapppet.data.remote.ApiKey
import com.arlekin.moviesapppet.data.remote.MovieApi
import com.arlekin.moviesapppet.data.remote.RetrofitInstance
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val api: MovieApi
) {

    // todo: remove?
    suspend fun getMovies(): List<Movie> {
        val response = RetrofitInstance.api.getMovies(ApiKey.TMDB_API_KEY)

        return response.results.map {
            Movie(
                id = it.id,
                title = it.title,
                description = it.overview,
                posterUrl = "https://image.tmdb.org/t/p/w500${it.poster_path}",
                rating = it.vote_average,
                isFavorite = false,
            )
        }
    }
}

