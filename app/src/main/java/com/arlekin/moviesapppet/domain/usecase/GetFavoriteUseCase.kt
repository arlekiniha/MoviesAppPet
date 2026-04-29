package com.arlekin.moviesapppet.domain.usecase

import com.arlekin.moviesapppet.domain.repository.MovieRepository
import javax.inject.Inject

class GetFavoriteUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke() =
        repository.getFavorites()
}