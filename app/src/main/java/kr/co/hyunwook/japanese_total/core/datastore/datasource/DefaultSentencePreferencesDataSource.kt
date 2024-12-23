package kr.co.hyunwook.japanese_total.core.datastore.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kr.co.hyunwook.japanese_total.feature.main.onboarding.LevelType
import javax.inject.Inject
import javax.inject.Named
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey

class DefaultSentencePreferencesDataSource @Inject constructor(
    @Named("sentence") private val dataStore: DataStore<Preferences>
): SentencePreferencesDataSource {

    object PreferencesKey {
        val CURRENT_LEVEL = stringPreferencesKey("LEVEL")
    }

    override val currentLevel = dataStore.data.map { preferences ->
        val level = preferences[PreferencesKey.CURRENT_LEVEL]
        try {
            level?.let { LevelType.valueOf(it) } ?: LevelType.NONE
        } catch (e: IllegalArgumentException) {
            LevelType.NONE
        }

    }

    override suspend fun saveLevel(level: LevelType) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.CURRENT_LEVEL] = level.name
        }
    }




}
