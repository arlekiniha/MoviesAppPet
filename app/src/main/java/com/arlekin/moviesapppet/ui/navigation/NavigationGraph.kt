package com.arlekin.moviesapppet.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arlekin.design.theme.MoviesTheme
import com.arlekin.moviesapppet.ui.screens.FavoritesScreen
import com.arlekin.moviesapppet.ui.screens.MoviesScreen
import com.arlekin.moviesapppet.ui.viewModels.MovieViewModel

@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
) {
    Scaffold(
        containerColor = MoviesTheme.colors.surface,
        contentColor = MoviesTheme.colors.onSurface,
        bottomBar = {
            BottomBar(navController)
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = MoviesRoute,
            modifier = Modifier.padding(padding)
        ) {
            composable<MoviesRoute> {
                val vm: MovieViewModel = hiltViewModel()
                MoviesScreen(viewModel = vm)
            }

            composable<FavoriteRoute> {
                val vm: MovieViewModel = hiltViewModel()
                FavoritesScreen(navController = navController, viewModel = vm)
            }
        }
    }
}
