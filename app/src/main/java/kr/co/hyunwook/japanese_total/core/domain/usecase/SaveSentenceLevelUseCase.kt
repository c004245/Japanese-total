package kr.co.hyunwook.japanese_total.core.domain.usecase

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.co.hyunwook.japanese_total.core.data.repository.sentence.SentenceRepository
import kr.co.hyunwook.japanese_total.core.database.entity.Sentence
import kr.co.hyunwook.japanese_total.feature.main.onboarding.LevelType
import android.content.Context
import android.util.Log
import java.io.InputStreamReader
import javax.inject.Inject

/**
 * 난이도별 일본어 json을 room에 저장하는 usecase
 */
class SaveSentenceLevelUseCase @Inject constructor(
    private val sentenceRepository: SentenceRepository,
    private val context: Context
) {
    suspend operator fun invoke(params: Pair<Int, LevelType>): Flow<Result<Unit>> = flow {
        try {
            // JSON 파일 읽기
            val sentences = loadSentencesFromJson(params.first)

            // `saveSentences`와 `saveLevel` 병렬 실행
            coroutineScope {
                val saveSentencesJob = async { sentenceRepository.saveSentences(sentences) }
                val saveLevelJob = async { sentenceRepository.saveLevel(params.second) }

                // 두 작업이 완료될 때까지 기다림
                saveSentencesJob.await()
                saveLevelJob.await()
            }

            emit(Result.success(Unit))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    // JSON 파일에서 문장 데이터를 로드하는 함수
    private fun loadSentencesFromJson(resourceId: Int): List<Sentence> {
        val inputStream = context.resources.openRawResource(resourceId)
        val reader = InputStreamReader(inputStream)
        val type = object : TypeToken<List<Sentence>>() {}.type
        return Gson().fromJson(reader, type)
    }


}
