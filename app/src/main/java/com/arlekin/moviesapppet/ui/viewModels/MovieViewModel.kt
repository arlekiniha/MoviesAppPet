package com.arlekin.moviesapppet.ui.viewModels

import androidx.lifecycle.ViewModel
import com.arlekin.moviesapppet.data.model.Movie
import com.arlekin.moviesapppet.data.repository.FakeMoviesRepository

class MovieViewModel : ViewModel() {

    private val repository = FakeMoviesRepository()

    fun getMovies(): List<Movie> {
        return repository.getMovies()
    }
}