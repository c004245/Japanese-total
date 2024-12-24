package kr.co.hyunwook.japanese_total.feature.main.splash

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kr.co.hyunwook.japanese_total.core.domain.usecase.GetLevelUseCase
import kr.co.hyunwook.japanese_total.feature.main.onboarding.LevelType
import android.util.Log
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getLevelUseCase: GetLevelUseCase
): ViewModel() {
    private val _sideEffects = MutableSharedFlow<SplashSideEffect>()
    val sideEffects: SharedFlow<SplashSideEffect> get() = _sideEffects.asSharedFlow()

    fun showSplash() {
        viewModelScope.launch {
            delay(SPLASH_DURATION)
            getLevelUseCase().collect { level ->
                Log.d("HWO", "Level state -> $level")
                if (level == LevelType.NONE) {
                    _sideEffects.emit(SplashSideEffect.NavigateToOnBoarding)
                } else {
                    _sideEffects.emit(SplashSideEffect.NavigateToHome)
                }
            }

        }
    }

    companion object {
        const val SPLASH_DURATION = 500L
    }
}