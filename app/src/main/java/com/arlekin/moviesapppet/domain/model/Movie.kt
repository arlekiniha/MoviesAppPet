package com.arlekin.moviesapppet.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    val posterUrl: String,
    val rating: Double
)