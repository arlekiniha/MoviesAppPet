package com.arlekin.moviesapppet.ui.models

data class MovieUi(
    val id: Int,
    val title: String,
    val description: String,
    val posterUrl: String?,
    val rating: Double,
    val isFavorite: Boolean,
)
