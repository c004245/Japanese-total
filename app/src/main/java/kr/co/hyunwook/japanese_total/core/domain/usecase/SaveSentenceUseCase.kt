package kr.co.hyunwook.japanese_total.core.domain.usecase

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.co.hyunwook.japanese_total.core.data.repository.sentence.SentenceRepository
import kr.co.hyunwook.japanese_total.core.database.entity.Sentence
import android.content.Context
import android.util.Log
import java.io.InputStreamReader
import javax.inject.Inject

/**
 * 난이도별 일본어 json을 room에 저장하는 usecase
 */
class SaveSentenceUseCase @Inject constructor(
    private val sentenceRepository: SentenceRepository,
    private val context: Context
) {
    suspend operator fun invoke(jsonResId: Int): Flow<Result<Unit>> = flow {
        try {
            // JSON 파일 읽기
            val inputStream = context.resources.openRawResource(jsonResId)
            val reader = InputStreamReader(inputStream)
            val type = object : TypeToken<List<Sentence>>() {}.type
            val sentences: List<Sentence> = Gson().fromJson(reader, type)

            Log.d("HWO", "sentence usecase -> $sentences")

            sentenceRepository.saveSentences(sentences)

            emit(Result.success(Unit))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }


}
