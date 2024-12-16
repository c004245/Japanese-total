package kr.co.hyunwook.japanese_total.core.database

import kr.co.hyunwook.japanese_total.core.database.entity.Sentence
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Sentence::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun sentenceDao(): SentenceDao
}