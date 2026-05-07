package com.arlekin.design.theme.basic

import androidx.compose.ui.graphics.Color
import com.arlekin.design.theme.DsColors


internal val LightColors = DsColors(
    background = Color(0xFFFFFFFF),
    onBackground = Color(0xFF1A1A1A),

    surface = Color(0xFFF7F7F7),
    onSurface = Color(0xFF1A1A1A),

    surfaceVariant = Color(0xFFEAEAEA),
    onSurfaceVariant = Color(0xFF4D4D4D),

    outline = Color(0xFFCCCCCC),

    primary = Color(0xFF0057FF),
    onPrimary = Color(0xFFFFFFFF),

    secondary = Color(0xFF0066CC),
    onSecondary = Color(0xFFFFFFFF),

    error = Color(0xFFCC0000),
    onError = Color(0xFFFFFFFF)
)

internal val DarkColors = DsColors(
    background = Color(0xFF0B0B0F),
    onBackground = Color(0xFFFFFFFF),

    surface = Color(0xFF15151C),
    onSurface = Color(0xFFFFFFFF),

    surfaceVariant = Color(0xFF1E1E27),
    onSurfaceVariant = Color(0xFFB3B3C2),

    outline = Color(0xFF3A3A45),

    primary = Color(0xFFFFC107),
    onPrimary = Color(0xFF000000),

    secondary = Color(0xFFFFD54F),
    onSecondary = Color(0xFF000000),

    error = Color(0xFFFF5252),
    onError = Color(0xFFFFFFFF)
)