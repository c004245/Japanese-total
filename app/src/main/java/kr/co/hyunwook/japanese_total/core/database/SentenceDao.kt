package kr.co.hyunwook.japanese_total.core.database

import kr.co.hyunwook.japanese_total.core.database.entity.Sentence
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface SentenceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSentences(sentences: List<Sentence>)


}

