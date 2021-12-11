package com.surfsocial.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    background = Bunker,
    primary = White,
    primaryVariant = DodgerBlue,
    secondary = White
)

private val LightColorPalette = lightColors(
    background = Mercury,
    primary = Martinique,
    primaryVariant = AzureRadiance,
    secondary = Waterloo
)

@Composable
fun SurfSocialTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}