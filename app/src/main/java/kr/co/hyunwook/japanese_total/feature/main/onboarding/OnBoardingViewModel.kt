package kr.co.hyunwook.japanese_total.feature.main.onboarding

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kr.co.hyunwook.japanese_total.core.domain.usecase.SaveSentenceUseCase
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val saveSentenceUseCase: SaveSentenceUseCase
): ViewModel() {

    private val _saveDoneSentences = MutableSharedFlow<Boolean>()
    val saveDoneSentences: SharedFlow<Boolean> get() = _saveDoneSentences

    //json to room
    fun saveSentences(jsonResId: Int) {
        viewModelScope.launch {
            saveSentenceUseCase(jsonResId = jsonResId)
                .catch {
                    _saveDoneSentences.emit(false)
                }
                .collect { result ->
                    result.onSuccess {
                        _saveDoneSentences.emit(true)
                    }.onFailure { e ->
                        _saveDoneSentences.emit(false)
                    }
                }
        }

    }
}