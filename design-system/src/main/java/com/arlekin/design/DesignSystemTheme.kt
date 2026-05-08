package com.arlekin.design

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.arlekin.design.theme.LocalMoviesColorScheme
import com.arlekin.design.theme.basic.colors.DarkColors
import com.arlekin.design.theme.basic.colors.LightColors

@Composable
fun MoviesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors
    CompositionLocalProvider(
        LocalMoviesColorScheme provides colors,
        content = content,
    )
}
