package kr.co.hyunwook.japanese_total.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Sentence(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val japanese: String,
    val pronunciation: String,
    val meaning: String,
    var checked: Boolean = false
)


