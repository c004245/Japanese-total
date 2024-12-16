package kr.co.hyunwook.japanese_total.feature.home

import kr.co.hyunwook.japanese_total.R
import kr.co.hyunwook.japanese_total.ui.theme.JapaneseTotalTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
        Button(
            onClick = { },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Cyan
            )
        ) {
            Text(
                text = stringResource(id = R.string.text_next),
                style = JapaneseTotalTheme.typography.bold,
                color = Color.White,
                fontSize = 14.sp
            )
        }

    }
}