package com.arlekin.moviesapppet.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.arlekin.moviesapppet.R


data class BottomNavItem(
    val route: Any,
    val title: String,
    val icon: ImageVector
)

@Composable
fun BottomBar(navController: NavController) {

    val items = listOf(
        BottomNavItem(MoviesRoute, stringResource(R.string.movies), Icons.Default.Home),
        BottomNavItem(FavoriteRoute, stringResource(R.string.favorite), Icons.Default.Favorite)
    )

    NavigationBar {
        val navBackStackEntry = navController.currentBackStackEntryAsState()

        items.forEach { item ->
            NavigationBarItem(
                selected = navBackStackEntry.value?.destination?.route == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                    }
                },
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) }
            )
        }
    }
}
