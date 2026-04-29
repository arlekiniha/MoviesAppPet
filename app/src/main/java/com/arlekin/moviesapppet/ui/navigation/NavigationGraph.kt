package com.arlekin.moviesapppet.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.arlekin.moviesapppet.ui.screens.FavoritesScreen
import com.arlekin.moviesapppet.ui.screens.MoviesScreen
import com.arlekin.moviesapppet.ui.viewModels.MovieViewModel

@Composable
fun NavigationGraph(navController: NavHostController) {

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = "movies",
            modifier = Modifier.padding(padding)
        ) {

            composable("movies") {
                val vm: MovieViewModel = hiltViewModel()
                MoviesScreen( viewModel = vm)
            }

            composable("favorites") {
                val vm: MovieViewModel = hiltViewModel()
                FavoritesScreen(navController = navController, viewModel = vm)
            }
        }
    }
}
