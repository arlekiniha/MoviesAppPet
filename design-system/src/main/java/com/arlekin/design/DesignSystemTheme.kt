package com.arlekin.design

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.CompositionLocalProvider
import com.arlekin.design.theme.LocalMoviesColors
import com.arlekin.design.theme.LocalMoviesShapes
import com.arlekin.design.theme.LocalMoviesSpacing
import com.arlekin.design.theme.LocalMoviesTypography
import com.arlekin.design.theme.basic.DsShapes
import com.arlekin.design.theme.basic.DsSpacing
import com.arlekin.design.theme.basic.DsTypography
import com.arlekin.design.theme.basic.colors.DsColors
import com.arlekin.design.theme.basic.colors.DsColors.DsDarkColorScheme
import com.arlekin.design.theme.basic.colors.DsColors.DsLightColorScheme

@Composable
fun MoviesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DsDarkColorScheme else DsLightColorScheme
    val typography = DsTypography
    val spacing = DsSpacing
    val shapes = DsShapes

    CompositionLocalProvider(
        LocalMoviesColors provides DsColors,
        LocalMoviesTypography provides typography,
        LocalMoviesSpacing provides spacing,
        LocalMoviesShapes provides shapes
    ) {
        MaterialTheme(
            colorScheme = if (darkTheme) DsDarkColorScheme else DsLightColorScheme,
            typography = Typography(),
            shapes = Shapes(),
            content = content
        )
    }
}
