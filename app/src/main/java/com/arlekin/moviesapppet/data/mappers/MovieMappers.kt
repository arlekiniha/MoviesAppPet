package com.arlekin.moviesapppet.data.mappers

import com.arlekin.moviesapppet.data.local.entity.MovieEntity
import com.arlekin.moviesapppet.data.model.MovieDto
import com.arlekin.moviesapppet.domain.model.Movie

fun MovieEntity.toDomain(): Movie {
    return Movie(
        id= id,
        title = title,
        description = description,
        posterUrl = posterUrl,
        rating = rating
    )
}

fun Movie.toEntity(): MovieEntity{
    return MovieEntity(
        id= id,
        title = title,
        description = description,
        posterUrl = posterUrl,
        rating = rating,
    )
}

fun MovieDto.toDomain(): Movie {
    return Movie(
        id = id,
        title = title,
        description = overview,
        posterUrl = poster_path?.let { "https://image.tmdb.org/t/p/w500$it" } ?: "",
        rating = vote_average
    )
}
