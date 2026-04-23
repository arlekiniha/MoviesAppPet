package com.arlekin.moviesapppet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.arlekin.moviesapppet.ui.screens.MainScreen
import com.arlekin.moviesapppet.ui.theme.MoviesAppPetTheme
import com.arlekin.moviesapppet.ui.viewModels.MovieViewModel
import kotlin.getValue

class MainActivity : ComponentActivity() {

    private val vm: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MoviesAppPetTheme {
                MainScreen(viewModel = vm)
            }
        }
    }
}



