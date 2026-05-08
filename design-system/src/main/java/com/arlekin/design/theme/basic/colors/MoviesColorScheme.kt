package com.arlekin.design.theme.basic.colors

import androidx.compose.ui.graphics.Color

data class MoviesColorScheme(
    val surface: Color,
    val onSurface: Color,

    val surfaceVariant: Color,
    val onSurfaceVariant: Color,

    val outline: Color,

    val primary: Color,
    val onPrimary: Color,

    val disabled: Color,
    val onDisabled: Color,

    val secondary: Color,
    val onSecondary: Color,

    val error: Color,
    val onError: Color
)

internal val DarkColors = MoviesColorScheme(
    surface = PrimitiveColors.Brown900,
    onSurface = PrimitiveColors.Red50,
    surfaceVariant = PrimitiveColors.Violet700,
    onSurfaceVariant = PrimitiveColors.Red50,
    outline = PrimitiveColors.Rose400,
    primary = PrimitiveColors.Red100,
    onPrimary = PrimitiveColors.Red900,
    secondary = PrimitiveColors.Violet200,
    onSecondary = PrimitiveColors.Violet900,
    error = PrimitiveColors.Red100,
    onError = PrimitiveColors.Red900,
    disabled = PrimitiveColors.Grey700,
    onDisabled = PrimitiveColors.Grey10,
)

internal val LightColors = MoviesColorScheme(
    surface = PrimitiveColors.Red10,
    onSurface = PrimitiveColors.Brown900,
    surfaceVariant = PrimitiveColors.Violet200,
    onSurfaceVariant = PrimitiveColors.Red10,
    outline = PrimitiveColors.Rose600,
    primary = PrimitiveColors.Red600,
    onPrimary = PrimitiveColors.Red10,
    secondary = PrimitiveColors.Violet700,
    onSecondary = PrimitiveColors.Violet10,
    error = PrimitiveColors.Red600,
    onError = PrimitiveColors.Red10,
    disabled = PrimitiveColors.Grey10,
    onDisabled = PrimitiveColors.Grey700,
)
