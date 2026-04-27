package com.arlekin.moviesapppet.util.usecase

import com.arlekin.moviesapppet.domain.repository.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
){
    suspend operator fun invoke() = repository.getMovies()
}