package com.arlekin.moviesapppet.data.mappers

import com.arlekin.moviesapppet.data.local.entity.MovieEntity
import com.arlekin.moviesapppet.data.model.MovieDto
import com.arlekin.moviesapppet.domain.model.Movie

fun MovieEntity.toDomain(): Movie {
    return Movie(
        id = id,
        title = title,
        description = description,
        posterUrl = posterUrl,
        rating = rating,
        isFavorite = isFavorite,
    )
}

fun Movie.toEntity(): MovieEntity{
    return MovieEntity(
        id= id,
        title = title,
        description = description,
        posterUrl = posterUrl,
        rating = rating,
        isFavorite = isFavorite,
    )
}

fun MovieDto.toEntity(): MovieEntity {
    return MovieEntity(
        id = id,
        title = title,
        description = overview,
        posterUrl = poster_path,
        rating = vote_average,
        isFavorite = false,
    )
}
