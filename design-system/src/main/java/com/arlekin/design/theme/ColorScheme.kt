package com.arlekin.design.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

private object DsLightColors {
    val background = Color(0xFFFFFFFF)
    val onBackground = Color(0xFF1A1A1A)

    val surface = Color(0xFFF7F7F7)
    val onSurface = Color(0xFF1A1A1A)

    val surfaceVariant = Color(0xFFEAEAEA)
    val onSurfaceVariant = Color(0xFF4D4D4D)

    val outline = Color(0xFFCCCCCC)

    val primary = Color(0xFF0057FF)
    val onPrimary = Color(0xFFFFFFFF)

    val secondary = Color(0xFF0066CC)
    val onSecondary = Color(0xFFFFFFFF)

    val error = Color(0xFFCC0000)
    val onError = Color(0xFFFFFFFF)
}

val DsLightColorScheme = lightColorScheme(
    background = DsLightColors.background,
    onBackground = DsLightColors.onBackground,
    surface = DsLightColors.surface,
    onSurface = DsLightColors.onSurface,
    surfaceVariant = DsLightColors.surfaceVariant,
    onSurfaceVariant = DsLightColors.onSurfaceVariant,
    outline = DsLightColors.outline,
    primary = DsLightColors.primary,
    onPrimary = DsLightColors.onPrimary,
    secondary = DsLightColors.secondary,
    onSecondary = DsLightColors.onSecondary,
    error = DsLightColors.error,
    onError = DsLightColors.onError
)

private object DsDarkColors {
    val background = Color(0xFF0B0B0F)
    val onBackground = Color(0xFFFFFFFF)

    val surface = Color(0xFF15151C)
    val onSurface = Color(0xFFFFFFFF)

    val surfaceVariant = Color(0xFF1E1E27)
    val onSurfaceVariant = Color(0xFFB3B3C2)

    val outline = Color(0xFF3A3A45)

    val primary = Color(0xFFFFC107)
    val onPrimary = Color(0xFF000000)

    val secondary = Color(0xFFFFD54F)
    val onSecondary = Color(0xFF000000)

    val error = Color(0xFFFF5252)
    val onError = Color(0xFFFFFFFF)
}

val DsDarkColorScheme = darkColorScheme(
    background = DsDarkColors.background,
    onBackground = DsDarkColors.onBackground,
    surface = DsDarkColors.surface,
    onSurface = DsDarkColors.onSurface,
    surfaceVariant = DsDarkColors.surfaceVariant,
    onSurfaceVariant = DsDarkColors.onSurfaceVariant,
    outline = DsDarkColors.outline,
    primary = DsDarkColors.primary,
    onPrimary = DsDarkColors.onPrimary,
    secondary = DsDarkColors.secondary,
    onSecondary = DsDarkColors.onSecondary,
    error = DsDarkColors.error,
    onError = DsDarkColors.onError
)
