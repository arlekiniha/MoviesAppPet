package com.arlekin.moviesapppet.data.repository

import com.arlekin.moviesapppet.data.model.Movie



class FakeMoviesRepository {
    val fakeRep = listOf<Movie>(
        Movie(1, "Batman", "Description for Batman"),
        Movie(2, "Interstellar", "Description for Interstellar"),
        Movie(3, "Inception", "Description for Inception"),
        Movie(3, "Inception", "Description for Inception"),
        Movie(3, "Inception", "Description for Inception"),
        Movie(3, "Inception", "Description for Inception"),
        Movie(3, "Inception", "Description for Inception"),
        Movie(3, "Inception", "Description for Inception"),
        Movie(3, "Inception", "Description for Inception"),
        Movie(3, "Inception", "Description for Inception"),
        Movie(3, "Inception", "Description for Inception"),
        Movie(3, "Inception", "Description for Inception"),
        Movie(3, "Inception", "Description for Inception"),
        Movie(3, "Inception", "Description for Inception"),
        Movie(3, "Inception", "Description for Inception"),
        Movie(3, "Inception", "Description for Inception"),
        Movie(3, "Inception", "Description for Inception"),
    )
    fun getMovies(): List<Movie> = fakeRep
}