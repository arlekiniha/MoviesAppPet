package com.arlekin.moviesapppet.domain.usecase

import com.arlekin.moviesapppet.domain.model.Movie
import com.arlekin.moviesapppet.domain.repository.MovieRepository
import javax.inject.Inject

class AddFavouriteUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(movie: Movie) =
        repository.addFavorite(movie)
}