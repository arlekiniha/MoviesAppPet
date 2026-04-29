package com.arlekin.moviesapppet.di

import com.arlekin.moviesapppet.domain.repository.MovieRepository
import com.arlekin.moviesapppet.domain.usecase.AddFavouriteUseCase
import com.arlekin.moviesapppet.domain.usecase.GetFavoriteUseCase
import com.arlekin.moviesapppet.domain.usecase.GetMoviesUseCase
import com.arlekin.moviesapppet.domain.usecase.RemoveFavoriteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    @Singleton
    fun provideGetMoviesUseCase(repository: MovieRepository): GetMoviesUseCase =
        GetMoviesUseCase(repository)

    @Provides
    @Singleton
    fun provideAddFavoriteUseCase(repository: MovieRepository): AddFavouriteUseCase =
        AddFavouriteUseCase(repository)

    @Provides
    @Singleton
    fun provideRemoveFavoriteUseCase(repository: MovieRepository): RemoveFavoriteUseCase =
        RemoveFavoriteUseCase(repository)

    @Provides
    @Singleton
    fun provideGetFavoritesUseCase(repository: MovieRepository): GetFavoriteUseCase =
        GetFavoriteUseCase(repository)
}
