package kr.co.hyunwook.japanese_total.feature.main.onboarding

import kr.co.hyunwook.japanese_total.R
import kr.co.hyunwook.japanese_total.ui.theme.JapaneseTotalTheme
import kr.co.hyunwook.japanese_total.util.scheduleDailyNotification
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun OnBoardingScreen(
    navigateToHome: () -> Unit = {},
    onBoardingViewModel: OnBoardingViewModel = hiltViewModel()
) {

    val context = LocalContext.current.applicationContext

    LaunchedEffect(Unit) {
        onBoardingViewModel.saveDoneSentences.collect { isSuccess ->
            if (isSuccess) {
                Toast.makeText(context, "난이도에 맞는 단어 저장완료!", Toast.LENGTH_LONG).show()
                navigateToHome()
            }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = {
                onBoardingViewModel.saveSentences(R.raw.japanese_sentences_basic)
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(
                    PaddingValues(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    )
                ),

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


