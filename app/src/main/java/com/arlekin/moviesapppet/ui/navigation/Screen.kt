package com.arlekin.moviesapppet.ui.navigation

sealed class Screen(val route: String) {
    object Movie : Screen("movies")
    object Favorites : Screen("favorites")
}