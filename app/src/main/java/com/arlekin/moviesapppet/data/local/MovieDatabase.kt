package com.arlekin.moviesapppet.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arlekin.moviesapppet.data.local.dao.MovieDao
import com.arlekin.moviesapppet.data.local.entity.MovieEntity

@Database(
    entities = [MovieEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}