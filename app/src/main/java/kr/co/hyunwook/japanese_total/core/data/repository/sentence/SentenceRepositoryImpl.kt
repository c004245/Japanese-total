package kr.co.hyunwook.japanese_total.core.data.repository.sentence

import kr.co.hyunwook.japanese_total.core.database.SentenceDao
import kr.co.hyunwook.japanese_total.core.database.entity.Sentence
import javax.inject.Inject

class SentenceRepositoryImpl @Inject constructor(
    private val sentenceDao: SentenceDao
):  SentenceRepository {
    override suspend fun saveSentences(sentences: List<Sentence>) {
        sentenceDao.insertSentences(sentences)
    }
}
