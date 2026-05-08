package com.arlekin.design.theme.basic.colors

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

private object DsLightColors {
    val background = Colors.Red10
    val onBackground = Colors.Red50

    val surface = Colors.Red10
    val onSurface = Colors.Red50

    val surfaceVariant = Colors.Red100 //no specific color for surfaceVariant in the ticket
    val onSurfaceVariant = Colors.Red100

    val outline = Colors.Rose400

    val primary = Colors.Red100
    val onPrimary = Colors.Red10

    val secondary = Colors.Violet200
    val onSecondary = Colors.Violet10

    val error = Colors.Red100
    val onError = Colors.Red10
}



private object DsDarkColors {
    val background = Colors.Brown900
    val onBackground = Colors.Brown900

    val surface = Colors.Brown900
    val onSurface = Colors.Brown900

    val surfaceVariant = Colors.Brown800
    val onSurfaceVariant = Colors.Brown700
    val outline = Colors.Rose600

    val primary = Colors.Red600
    val onPrimary = Colors.Red900

    val secondary = Colors.Violet700
    val onSecondary = Colors.Violet900

    val error = Colors.Red600
    val onError = Colors.Red900
}


object DsColors {

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

}
