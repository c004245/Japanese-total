package kr.co.hyunwook.japanese_total.core.data.repository.sentence

import kotlinx.coroutines.flow.Flow
import kr.co.hyunwook.japanese_total.core.database.entity.Sentence

interface SentenceRepository {
    suspend fun saveSentences(sentences: List<Sentence>)

    suspend fun getUnCheckedRandomSentence(): Flow<Sentence>

    suspend fun updateCheckSentence(id: Int)
}

