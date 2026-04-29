package com.arlekin.moviesapppet.data.repository

import com.arlekin.moviesapppet.data.local.dao.MovieDao
import com.arlekin.moviesapppet.data.mappers.toDomain
import com.arlekin.moviesapppet.data.mappers.toEntity
import com.arlekin.moviesapppet.data.remote.ApiKey
import com.arlekin.moviesapppet.data.remote.MovieApi
import com.arlekin.moviesapppet.domain.model.Movie
import com.arlekin.moviesapppet.domain.repository.MovieRepository
import com.arlekin.moviesapppet.util.DomainError
import com.arlekin.moviesapppet.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApi,
    private val dao: MovieDao
) : MovieRepository {

    override val movies: Flow<List<Movie>> = dao.getAllMovies().map { movies ->
        movies.map { it.toDomain() }
    }

    override val favoritesMovies: Flow<List<Movie>> =
        dao.getFavouriteMovies().map { movies -> movies.map { it.toDomain() } }

    override suspend fun fetchMovies(): Resource<Unit> = withContext(Dispatchers.IO) {
        try {
            val response = api.getMovies(apiKey = ApiKey.TMDB_API_KEY)
            val movies = response.results.map { it.toEntity() }
            dao.insertAllMoviesSafely(movies)
            Resource.Success(Unit)
        } catch (_: Exception) {
            Resource.Failure(DomainError.RemoteError)
        }
    }

    override suspend fun updateIsFavorite(movieId: Int, isFavorite: Boolean) {
        dao.setIsFavoriteMovie(movieId, isFavorite)
    }

    override suspend fun removeFavorite(movieId: Int) {
        dao.deleteMovie(movieId)
    }
}


