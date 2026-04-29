package com.arlekin.moviesapppet.domain.usecase

import com.arlekin.moviesapppet.domain.repository.MovieRepository
import javax.inject.Inject

class AddFavouriteUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(movieId: Int) =
        repository.updateIsFavorite(movieId, true)
}