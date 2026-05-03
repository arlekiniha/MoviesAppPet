package com.arlekin.moviesapppet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.arlekin.moviesapppet.ui.navigation.NavigationGraph
import com.arlekin.moviesapppet.ui.theme.MoviesAppPetTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MoviesAppPetTheme(darkTheme = true) {
                Surface(color = MaterialTheme.colorScheme.background) {

                    val navController = rememberNavController()

                    NavigationGraph(navController)
                }
            }
        }
    }
}
