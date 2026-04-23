package com.arlekin.moviesapppet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arlekin.moviesapppet.ui.screens.DetailScreen
import com.arlekin.moviesapppet.ui.screens.MainScreen
import com.arlekin.moviesapppet.ui.theme.MoviesAppPetTheme
import com.arlekin.moviesapppet.ui.viewModels.MovieViewModel
import kotlin.getValue

class MainActivity : ComponentActivity() {

    private val vm: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            setContent {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "main"
                ) {
                    composable("main") {
                        MainScreen(navController = navController)
                    }

                    composable(
                        route = "details/{movieId}"
                    ) { backStackEntry ->
                        val movieId = backStackEntry.arguments?.getString("movieId")?.toInt()
                        DetailScreen(movieId = movieId!!)
                    }
                }
        }
    }
}}



