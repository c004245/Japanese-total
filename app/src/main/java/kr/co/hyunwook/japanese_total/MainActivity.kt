package kr.co.hyunwook.japanese_total

import dagger.hilt.android.AndroidEntryPoint
import kr.co.hyunwook.japanese_total.feature.main.MainScreen
import kr.co.hyunwook.japanese_total.feature.main.rememberMainNavigator
import kr.co.hyunwook.japanese_total.ui.theme.JapaneseTotalTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navigator = rememberMainNavigator()
            JapaneseTotalTheme {
                CompositionLocalProvider {
                    MainScreen(navigator = navigator)
                }
            }
        }
    }
}


