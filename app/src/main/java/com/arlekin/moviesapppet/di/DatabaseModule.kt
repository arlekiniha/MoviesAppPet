package com.arlekin.moviesapppet.di

import android.content.Context
import androidx.room.Room
import com.arlekin.moviesapppet.data.local.MovieDatabase
import com.arlekin.moviesapppet.data.local.dao.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MovieDatabase =
        Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            "movies_db"
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideMovieDao(db: MovieDatabase): MovieDao =
        db.movieDao()
}