package com.arlekin.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.arlekin.design.theme.basic.DarkColors
import com.arlekin.design.theme.basic.LightColors

@Composable
fun MoviesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    CompositionLocalProvider(
        LocalMoviesColors provides colors
    ) {
        MaterialTheme(
            colorScheme = if (darkTheme) DsDarkColorScheme else DsLightColorScheme,
            content = content
        )
    }
}

