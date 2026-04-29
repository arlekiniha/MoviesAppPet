package com.arlekin.moviesapppet.data.local.dao

import androidx.room.Dao
import androidx.room.OnConflictStrategy
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.arlekin.moviesapppet.data.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: MovieEntity)

    @Query("UPDATE movies SET isFavorite = :isFavorite WHERE id = :movieId")
    suspend fun setIsFavoriteMovie(movieId: Int, isFavorite: Boolean)

    // TODO: make it better (use separate table)
    @Transaction
    suspend fun insertAllMoviesSafely(movies: List<MovieEntity>) {
        val favoriteMovies: List<MovieEntity> = getFavouriteMovies().first()

        val resultMovies = movies.map { movie ->
            if (movie.id in favoriteMovies.map { it.id }) {
                movie.copy(
                    isFavorite = true,
                )
            } else movie
        }

        insertAllMovies(resultMovies)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMovies(movies: List<MovieEntity>)

    @Query("DELETE FROM movies WHERE id = :movieId")
    suspend fun deleteMovie(movieId: Int)

    @Query("SELECT * FROM movies")
    fun getAllMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movies WHERE isFavorite = 1")
    fun getFavouriteMovies(): Flow<List<MovieEntity>>


    @Query("SELECT * FROM movies WHERE id = :id LIMIT 1")
    suspend fun getMoviesById(id: Int): MovieEntity?
}