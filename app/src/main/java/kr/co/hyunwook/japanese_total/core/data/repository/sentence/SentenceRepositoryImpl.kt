package kr.co.hyunwook.japanese_total.core.data.repository.sentence

import kotlinx.coroutines.flow.Flow
import kr.co.hyunwook.japanese_total.core.database.SentenceDao
import kr.co.hyunwook.japanese_total.core.database.entity.Sentence
import kr.co.hyunwook.japanese_total.core.datastore.datasource.SentencePreferencesDataSource
import kr.co.hyunwook.japanese_total.feature.main.onboarding.LevelType
import javax.inject.Inject

class SentenceRepositoryImpl @Inject constructor(
    private val sentenceDao: SentenceDao,
    private val sentencesDataSource: SentencePreferencesDataSource
):  SentenceRepository {
    override suspend fun saveSentences(sentences: List<Sentence>) {
        sentenceDao.insertSentences(sentences)
    }

    override suspend fun getUnCheckedRandomSentences(): List<Sentence> {
       return sentenceDao.getUnCheckedRandomSentences()
    }

    override suspend fun updateCheckSentences(ids: List<Int>) {
        sentenceDao.updateCheckSentence(ids)
    }

    override suspend fun saveLevel(levelType: LevelType) {
        sentencesDataSource.saveLevel(levelType)
    }

    override suspend fun getLevel(): Flow<LevelType> = sentencesDataSource.currentLevel
}
