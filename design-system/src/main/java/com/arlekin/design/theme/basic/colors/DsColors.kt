package com.arlekin.design.theme.basic.colors

import androidx.compose.ui.graphics.Color

data class DsColorsModel(
    val background: Color,
    val onBackground: Color,

    val surface: Color,
    val onSurface: Color,

    val surfaceVariant: Color,
    val onSurfaceVariant: Color,

    val outline: Color,

    val primary: Color,
    val onPrimary: Color,

    val secondary: Color,
    val onSecondary: Color,

    val error: Color,
    val onError: Color
)