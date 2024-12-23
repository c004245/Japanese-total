package kr.co.hyunwook.japanese_total.feature.main.onboarding

import kr.co.hyunwook.japanese_total.R
import kr.co.hyunwook.japanese_total.ui.theme.JapaneseTotalTheme
import kr.co.hyunwook.japanese_total.util.scheduleDailyNotification
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
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

    var currentLevel by remember { mutableStateOf(LevelType.NONE) }

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
        LevelCheckScreen(
            currentLevel = currentLevel,
            onLevelCheck = { level ->
                Log.d("HWO", "check state -> ${level}")
                currentLevel = level
            }
        )
        Button(
            onClick = {
                when (currentLevel) {
                    LevelType.BASIC -> {
                        onBoardingViewModel.saveSentences(R.raw.japanese_sentences_basic, currentLevel)
                    }
                    LevelType.COMMON -> {
                        onBoardingViewModel.saveSentences(R.raw.japanese_sentences_basic, currentLevel)
                    }
                    LevelType.ADVANCE -> {
                        onBoardingViewModel.saveSentences(R.raw.japanese_sentences_basic, currentLevel)
                    } else -> {

                    }
                }
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


@Composable
fun LevelCheckScreen(
    currentLevel: LevelType,
    onLevelCheck: (LevelType) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LevelButton(
                levelType = LevelType.BASIC,
                currentLevel = currentLevel,
                onClick = onLevelCheck
            )
            Spacer(modifier = Modifier.height(8.dp))
            LevelButton(
                levelType = LevelType.COMMON,
                currentLevel = currentLevel,
                onClick = onLevelCheck
            )
            Spacer(modifier = Modifier.height(8.dp))
            LevelButton(
                levelType = LevelType.ADVANCE,
                currentLevel = currentLevel,
                onClick = onLevelCheck
            )
        }
    }
}


@Composable
fun LevelButton(
    levelType: LevelType,
    currentLevel: LevelType,
    onClick: (LevelType) -> Unit
) {
    Button(
        onClick = { onClick(levelType) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (currentLevel == levelType) Color.Red else Color.Cyan
        )
    ) {
        Text(
            text = when (levelType) {
                LevelType.BASIC -> stringResource(id = R.string.text_level_basic)
                LevelType.COMMON -> stringResource(id = R.string.text_level_common)
                LevelType.ADVANCE -> stringResource(id = R.string.text_level_advance)
                else -> ""
            },
            style = JapaneseTotalTheme.typography.bold,
            color = Color.Black,
            fontSize = 24.sp
        )
    }
}

enum class LevelType {
    NONE,
    BASIC,
    COMMON,
    ADVANCE

}
