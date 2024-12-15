package kr.co.hyunwook.japanese_total.ui.theme

import kr.co.hyunwook.japanese_total.core.designsystem.theme.JapaneseTotalTypography
import kr.co.hyunwook.japanese_total.core.designsystem.theme.japaneseTotalTypography
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = lightColorScheme(
    primary = White.copy(alpha = 0.99f),
    background = White,
)

private val LightColorScheme = lightColorScheme(
    primary = White.copy(alpha = 0.99f),
    background = White,
)
private val LocalJapaneseTotalTypography = staticCompositionLocalOf<JapaneseTotalTypography> {
    error("No JapaneseTotalTypography provided")
}
@Composable
fun ProvideJapaneseTotalTypography(typography: JapaneseTotalTypography, content: @Composable () -> Unit) {
    val provideTypography = remember { typography.copy() }
    provideTypography.update(typography)
    CompositionLocalProvider(
        LocalJapaneseTotalTypography provides provideTypography,
        content = content

    )
}

object JapaneseTotalTheme {
    val typography: JapaneseTotalTypography
        @Composable get() = LocalJapaneseTotalTypography.current
}
@Composable
fun JapaneseTotalTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }
    val typography = japaneseTotalTypography()

    // set status bar & navigation bar color
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            window.navigationBarColor = White.toArgb()

            WindowCompat.getInsetsController(window, view)
                .isAppearanceLightStatusBars = true
            WindowCompat.getInsetsController(window, view)
                .isAppearanceLightNavigationBars = true
        }
    }

    ProvideJapaneseTotalTypography(typography = typography) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}