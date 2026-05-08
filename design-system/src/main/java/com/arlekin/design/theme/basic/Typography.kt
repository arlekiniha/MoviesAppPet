package com.arlekin.design.theme.basic

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.arlekin.design_system.R

private val SplineSans = FontFamily(
    Font(R.font.splinesans_bold, FontWeight.W700),
    Font(R.font.splinesans_semibold, FontWeight.W600),
    Font(R.font.splinesans_medium, FontWeight.W500),
    Font(R.font.splinesans_regular, FontWeight.W400),
    Font(R.font.splinesans_light, FontWeight.W300)
)

private val Inter = FontFamily(
    Font(R.font.inter_regular, FontWeight.W400),
    Font(R.font.inter_medium, FontWeight.W500),
    Font(R.font.inter_semibold, FontWeight.W600)
)

data class MoviesTypography(
    val h1: TextStyle,
    val h2: TextStyle,
    val bodyLg: TextStyle,
    val bodyMd: TextStyle,
    val labelMd: TextStyle,
    val labelSm: TextStyle,
)

internal val DefaultMoviesTypography = MoviesTypography(
    h1 = TextStyle(
        fontFamily = SplineSans,
        fontSize = 32.sp,
        fontWeight = FontWeight.W700,
        lineHeight = 40.sp,
        letterSpacing = (-0.02).em
    ),

    h2 = TextStyle(
        fontFamily = SplineSans,
        fontSize = 24.sp,
        fontWeight = FontWeight.W600,
        lineHeight = 32.sp,
        letterSpacing = (-0.01).em
    ),

    bodyLg = TextStyle(
        fontFamily = Inter,
        fontSize = 18.sp,
        fontWeight = FontWeight.W400,
        lineHeight = 28.sp
    ),

    bodyMd = TextStyle(
        fontFamily = Inter,
        fontSize = 16.sp,
        fontWeight = FontWeight.W400,
        lineHeight = 24.sp
    ),

    labelMd = TextStyle(
        fontFamily = Inter,
        fontSize = 14.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 20.sp,
        letterSpacing = 0.01.em
    ),

    labelSm = TextStyle(
        fontFamily = Inter,
        fontSize = 12.sp,
        fontWeight = FontWeight.W600,
        lineHeight = 16.sp,
        letterSpacing = 0.05.em
    ),
)
