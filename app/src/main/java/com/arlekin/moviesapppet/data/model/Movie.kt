package com.arlekin.moviesapppet.data.model

data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    val posterUrl: String?,
    val rating: Double
)

