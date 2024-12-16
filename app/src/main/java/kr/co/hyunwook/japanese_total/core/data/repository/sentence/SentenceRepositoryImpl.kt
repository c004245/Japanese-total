package kr.co.hyunwook.japanese_total.core.data.repository.sentence

import kotlinx.coroutines.flow.Flow
import kr.co.hyunwook.japanese_total.core.database.SentenceDao
import kr.co.hyunwook.japanese_total.core.database.entity.Sentence
import javax.inject.Inject

class SentenceRepositoryImpl @Inject constructor(
    private val sentenceDao: SentenceDao
):  SentenceRepository {
    override suspend fun saveSentences(sentences: List<Sentence>) {
        sentenceDao.insertSentences(sentences)
    }

    override suspend fun getUnCheckedRandomSentence(): Sentence {
       return sentenceDao.getUnCheckedRandomSentence()
    }

    override suspend fun updateCheckSentence(id: Int) {
        sentenceDao.updateCheckSentence(id)
    }
}
