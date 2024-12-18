package kr.co.hyunwook.japanese_total

import dagger.hilt.android.AndroidEntryPoint
import kr.co.hyunwook.japanese_total.feature.main.MainNavigator
import kr.co.hyunwook.japanese_total.feature.main.MainScreen
import kr.co.hyunwook.japanese_total.feature.main.rememberMainNavigator
import kr.co.hyunwook.japanese_total.ui.theme.JapaneseTotalTheme
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.collection.arrayMapOf
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.core.content.ContextCompat

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private val permissions = arrayOf(
        android.Manifest.permission.POST_NOTIFICATIONS
    )

    private val requestPermissionsLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val allGranted = permissions.values.all { it }
            if (allGranted) {
                showMainScreen()
            } else {
                showPermissionDeniedMessage()
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if (hasAllPermissions()) {
            showMainScreen()
        } else {
            requestPermissionsLauncher.launch(permissions)
        }
    }
    private fun showMainScreen() {
        setContent {
            val navigator = rememberMainNavigator()
            JapaneseTotalTheme {
                CompositionLocalProvider {
                    MainScreen(navigator = navigator)
                }
            }
        }
    }


    private fun hasAllPermissions(): Boolean {
        return permissions.all { permission ->
            ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
        }
    }

    private fun showPermissionDeniedMessage() {
        setContent {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("권한이 필요합니다. 설정에서 권한을 허용해주세요.", textAlign = TextAlign.Center)
            }
        }
    }

}


