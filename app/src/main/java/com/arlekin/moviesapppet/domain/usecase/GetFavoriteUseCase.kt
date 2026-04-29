package com.arlekin.moviesapppet.domain.usecase

import com.arlekin.moviesapppet.domain.model.Movie
import com.arlekin.moviesapppet.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(): Flow<List<Movie>> =
        repository.favoritesMovies
}