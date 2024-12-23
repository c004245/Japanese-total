package kr.co.hyunwook.japanese_total.core.datastore.datasource

import kotlinx.coroutines.flow.Flow
import kr.co.hyunwook.japanese_total.feature.main.onboarding.LevelType

interface SentencePreferencesDataSource {
    val currentLevel: Flow<LevelType>

    suspend fun saveLevel(level: LevelType)
}
