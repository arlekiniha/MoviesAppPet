package com.arlekin.design.theme

import androidx.compose.runtime.Composable
import com.arlekin.design.theme.basic.DsShapes
import com.arlekin.design.theme.basic.DsSpacing
import com.arlekin.design.theme.basic.DsTypography

object MoviesTheme {

    val colors: DsColors
        @Composable get() = LocalMoviesColors.current

    val typography: DsTypography
        @Composable get() = LocalMoviesTypography.current

    val spacing: DsSpacing
        @Composable get() = LocalMoviesSpacing.current

    val shapes: DsShapes
        @Composable get() = LocalMoviesShapes.current
}
