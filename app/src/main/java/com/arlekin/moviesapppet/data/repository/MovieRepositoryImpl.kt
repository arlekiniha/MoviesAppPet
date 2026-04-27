package com.arlekin.moviesapppet.data.repository

import com.arlekin.moviesapppet.data.local.dao.MovieDao
import com.arlekin.moviesapppet.data.mappers.toDomain
import com.arlekin.moviesapppet.data.mappers.toEntity
import com.arlekin.moviesapppet.data.remote.ApiKey
import com.arlekin.moviesapppet.data.remote.MovieApi
import com.arlekin.moviesapppet.domain.model.Movie
import com.arlekin.moviesapppet.domain.repository.MovieRepository
import com.arlekin.moviesapppet.util.Resource
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApi,
    private val dao: MovieDao
) : MovieRepository {

    override suspend fun getMovies(): Resource<List<Movie>> {
        return try {
            val response = api.getMovies(apiKey = ApiKey.TMDB_API_KEY)
            val movies = response.results.map { it.toDomain() }
            Resource.Success(movies)
        } catch (e: Exception) {
            Resource.Error("Failed to load movies")
        }
    }

    override suspend fun addFavorite(movie: Movie) {
        dao.insertMovie(movie.toEntity())
    }

    override suspend fun removeFavorite(movieId: Int) {
        val entity = dao.getMoviesById(movieId)
        if (entity != null) {
            dao.deleteMovie(entity)
        }
    }

    override suspend fun getFavorites(): List<Movie> {
        return dao.getAllMovies().map { it.toDomain() }
    }
}


