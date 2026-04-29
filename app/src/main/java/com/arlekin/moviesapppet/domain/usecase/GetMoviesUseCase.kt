package com.arlekin.moviesapppet.domain.usecase

import com.arlekin.moviesapppet.domain.repository.MovieRepository
import com.arlekin.moviesapppet.util.Resource
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
){
    suspend operator fun invoke(): Resource<Unit> = repository.fetchMovies()
}