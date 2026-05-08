package com.arlekin.design.theme

import androidx.compose.runtime.staticCompositionLocalOf
import com.arlekin.design.theme.basic.DsShapes
import com.arlekin.design.theme.basic.DsSpacing
import com.arlekin.design.theme.basic.DsTypography
import com.arlekin.design.theme.basic.colors.DsColors

val LocalMoviesColors = staticCompositionLocalOf<DsColors> {
    error("no colors provided")
}
val LocalMoviesTypography = staticCompositionLocalOf { DsTypography }
val LocalMoviesSpacing = staticCompositionLocalOf { DsSpacing }
val LocalMoviesShapes = staticCompositionLocalOf { DsShapes }

//do i need to handle typography, spacing and shapes absence?