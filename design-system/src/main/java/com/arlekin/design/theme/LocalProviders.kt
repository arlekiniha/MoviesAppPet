package com.arlekin.design.theme

import androidx.compose.runtime.staticCompositionLocalOf
import com.arlekin.design.theme.basic.DefaultMoviesTypography
import com.arlekin.design.theme.basic.MoviesShapes
import com.arlekin.design.theme.basic.MoviesSpacing
import com.arlekin.design.theme.basic.MoviesTypography
import com.arlekin.design.theme.basic.colors.MoviesColorScheme

val LocalMoviesColorScheme = staticCompositionLocalOf<MoviesColorScheme> {
    error("no colors provided")
}

val LocalMoviesTypography = staticCompositionLocalOf { DefaultMoviesTypography }
val LocalMoviesSpacing = staticCompositionLocalOf { MoviesSpacing }
val LocalMoviesShapes = staticCompositionLocalOf { MoviesShapes }
