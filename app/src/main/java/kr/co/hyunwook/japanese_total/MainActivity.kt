package kr.co.hyunwook.japanese_total

import dagger.hilt.android.AndroidEntryPoint
import kr.co.hyunwook.japanese_total.feature.main.MainScreen
import kr.co.hyunwook.japanese_total.feature.main.rememberMainNavigator
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kr.co.hyunwook.japanese_total.ui.theme.JapanesetotalTheme
import androidx.compose.runtime.CompositionLocalProvider

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navigator = rememberMainNavigator()
            JapanesetotalTheme {
                CompositionLocalProvider {
                    MainScreen(navigator = navigator)
                }
            }
        }
    }
}


