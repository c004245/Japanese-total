package kr.co.hyunwook.japanese_total.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeRoute(
    paddingValues: PaddingValues
) {


    HomeScreen(
        paddingValues = paddingValues
    )
}


@Composable
fun HomeScreen(
    paddingValues: PaddingValues
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text("여기는 홈입니다")
    }
}