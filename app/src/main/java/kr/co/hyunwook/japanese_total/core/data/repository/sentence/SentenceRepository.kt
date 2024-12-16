package kr.co.hyunwook.japanese_total.core.data.repository.sentence

import kr.co.hyunwook.japanese_total.core.database.entity.Sentence

interface SentenceRepository {
    suspend fun saveSentences(sentences: List<Sentence>)
}
