package com.arlekin.moviesapppet.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

data class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
)

@Composable
fun BottomBar(navController: NavController) {

    val items = listOf(
        BottomNavItem("movies", "Movies", Icons.Default.Home),
        BottomNavItem("favorites", "Favorite", Icons.Default.Favorite)
    )

    NavigationBar {
        val navBackStackEntry = navController.currentBackStackEntryAsState()

        items.forEach { item ->
            NavigationBarItem(
                selected = navBackStackEntry.value?.destination?.route == item.route,
                onClick = { navController.navigate(item.route) },
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) }
            )
        }
    }
}
