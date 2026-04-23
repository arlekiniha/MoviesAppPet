package com.arlekin.moviesapppet.data.remote

import com.arlekin.moviesapppet.data.model.MovieDto
import retrofit2.http.GET

interface MovieApi {

    @GET("posts")
    suspend fun getMovies(): List<MovieDto>
}