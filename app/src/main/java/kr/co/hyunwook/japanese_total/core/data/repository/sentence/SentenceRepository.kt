package kr.co.hyunwook.japanese_total.core.data.repository.sentence

import kotlinx.coroutines.flow.Flow
import kr.co.hyunwook.japanese_total.core.database.entity.Sentence
import kr.co.hyunwook.japanese_total.feature.main.onboarding.LevelType

interface SentenceRepository {
    suspend fun saveSentences(sentences: List<Sentence>)

    suspend fun getUnCheckedRandomSentences(): List<Sentence>

    suspend fun updateCheckSentences(ids: List<Int>)

    suspend fun saveLevel(levelType: LevelType)

    suspend fun getLevel(): Flow<LevelType>
}

