package com.arlekin.moviesapppet.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val posterUrl: String,
    val rating: Double
)