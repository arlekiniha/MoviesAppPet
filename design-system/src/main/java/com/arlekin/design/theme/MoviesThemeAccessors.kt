package com.arlekin.design.theme

import androidx.compose.runtime.Composable
import com.arlekin.design.theme.basic.MoviesShapes
import com.arlekin.design.theme.basic.MoviesSpacing
import com.arlekin.design.theme.basic.MoviesTypography
import com.arlekin.design.theme.basic.colors.MoviesColorScheme

object MoviesTheme {
    val colors: MoviesColorScheme
        @Composable get() = LocalMoviesColorScheme.current

    val typography: MoviesTypography
        @Composable get() = LocalMoviesTypography.current

    val spacing: MoviesSpacing
        @Composable get() = LocalMoviesSpacing.current

    val shapes: MoviesShapes
        @Composable get() = LocalMoviesShapes.current
}
