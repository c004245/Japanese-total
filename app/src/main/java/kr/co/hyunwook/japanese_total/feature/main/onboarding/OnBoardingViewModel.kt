package kr.co.hyunwook.japanese_total.feature.main.onboarding

import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kr.co.hyunwook.japanese_total.core.domain.usecase.SaveSentenceLevelUseCase
import kr.co.hyunwook.japanese_total.util.scheduleDailyNotification
import android.content.Context
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val saveSentenceLevelUseCase: SaveSentenceLevelUseCase
): ViewModel() {

    private val _saveDoneSentences = MutableSharedFlow<Boolean>()
    val saveDoneSentences: SharedFlow<Boolean> get() = _saveDoneSentences

    //json to room
    fun saveSentenceLevel(jsonResId: Int, levelType: LevelType) {
        viewModelScope.launch {
            saveSentenceLevelUseCase(Pair(jsonResId, levelType))
                .catch {
                    _saveDoneSentences.emit(false)
                }
                .collect { result ->
                    result.onSuccess {
                        scheduleDailyNotification(context)
                        _saveDoneSentences.emit(true)
                    }.onFailure { e ->
                        _saveDoneSentences.emit(false)
                    }
                }
        }

    }
}
