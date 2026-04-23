package com.arlekin.moviesapppet.data.repository

import com.arlekin.moviesapppet.data.model.Movie
import com.arlekin.moviesapppet.data.remote.RetrofitInstance

class MovieRepository {

    suspend fun getMovies(): List<Movie> {
        return RetrofitInstance.api.getMovies().map {
            Movie(
                id = it.id,
                title = it.title,
                description = it.body
            )
        }
    }
}