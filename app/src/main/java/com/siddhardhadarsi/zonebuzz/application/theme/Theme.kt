package com.siddhardhadarsi.zonebuzz.application.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun ZoneBuzzTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    enableDynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val supportsDynamicColor = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    val lightColorScheme = lightColorScheme()
    val darkColorScheme = darkColorScheme()

    val colorScheme = when {
        (supportsDynamicColor && enableDynamicColor) && isDarkTheme -> {
            dynamicDarkColorScheme(LocalContext.current)
        }

        (supportsDynamicColor && enableDynamicColor) && !isDarkTheme -> {
            dynamicLightColorScheme(LocalContext.current)
        }

        isDarkTheme -> darkColorScheme
        else -> lightColorScheme
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = ZoneBuzzTypography,
        content = content
    )
}