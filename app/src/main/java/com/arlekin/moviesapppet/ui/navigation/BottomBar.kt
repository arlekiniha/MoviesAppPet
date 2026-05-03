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
    @StringRes val title: Int,
    val icon: ImageVector
)

val items = listOf(
    BottomNavItem(MoviesRoute, R.string.movies, Icons.Default.Home),
    BottomNavItem(FavoriteRoute, R.string.favorite, Icons.Default.Favorite)
)

@Composable
fun BottomBar(navController: NavController) {


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
                icon = { Icon(item.icon, contentDescription = stringResource(item.title)) },
                label = { Text(stringResource(item.title)) }
            )
        }
    }
}
