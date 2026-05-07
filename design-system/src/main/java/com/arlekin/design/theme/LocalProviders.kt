package com.arlekin.design.theme

import androidx.compose.runtime.staticCompositionLocalOf
import com.arlekin.design.theme.basic.DsShapes
import com.arlekin.design.theme.basic.DsSpacing
import com.arlekin.design.theme.basic.DsTypography

val LocalMoviesColors = staticCompositionLocalOf<DsColors> {
    error("no colors provided")
}
val LocalMoviesTypography = staticCompositionLocalOf { DsTypography }
val LocalMoviesSpacing = staticCompositionLocalOf { DsSpacing }
val LocalMoviesShapes = staticCompositionLocalOf { DsShapes }

//do i need to handle typography, spacing and shapes absence?