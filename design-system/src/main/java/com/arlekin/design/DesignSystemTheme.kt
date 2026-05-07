package com.arlekin.design

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.foundation.isSystemInDarkTheme
import com.arlekin.design.theme.DsDarkColorScheme
import com.arlekin.design.theme.DsLightColorScheme
import com.arlekin.design.theme.basic.DsTypography

@Composable
fun MoviesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DsDarkColorScheme else DsLightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = androidx.compose.material3.Typography(
            displayLarge = DsTypography.h1,
            displayMedium = DsTypography.h2,
            bodyLarge = DsTypography.bodyLg,
            bodyMedium = DsTypography.bodyMd,
            labelMedium = DsTypography.labelMd,
            labelSmall = DsTypography.labelSm
        ),
        content = content
    )
}