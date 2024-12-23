package kr.co.hyunwook.japanese_total.core.data.repository.sentence

import kr.co.hyunwook.japanese_total.core.database.entity.Sentence
import kr.co.hyunwook.japanese_total.feature.main.onboarding.LevelType

interface SentenceRepository {
    suspend fun saveSentences(sentences: List<Sentence>)

    suspend fun getUnCheckedRandomSentence(): Sentence

    suspend fun updateCheckSentence(id: Int)

    suspend fun saveLevel(levelType: LevelType)
}

