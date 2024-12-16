package kr.co.hyunwook.japanese_total.core.database

import kotlinx.coroutines.flow.Flow
import kr.co.hyunwook.japanese_total.core.database.entity.Sentence
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SentenceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSentences(sentences: List<Sentence>)


    //아직 보지 않은 일본어 문장 한개 랜덤 추출
    @Query("SELECT * FROM sentence WHERE checked = 0 ORDER BY RANDOM() LIMIT 1")
    suspend fun getUnCheckedRandomSentence(): Sentence

    //확인 한 일본어 문장을 본 상태로 바꾸기
    @Query("UPDATE sentence SET checked = 1 WHERE id = :id")
    suspend fun updateCheckSentence(id: Int)

}

