package com.arlekin.moviesapppet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.arlekin.design.MoviesTheme
import com.arlekin.design.theme.MoviesTheme
import com.arlekin.moviesapppet.ui.navigation.NavigationGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MoviesTheme {
                Surface(color = MoviesTheme.colors.surface) {
                    NavigationGraph()
                }
            }
        }
    }
}
