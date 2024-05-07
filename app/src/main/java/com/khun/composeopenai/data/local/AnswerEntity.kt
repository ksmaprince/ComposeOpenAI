package com.khun.composeopenai.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity("answers")
data class AnswerEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val role: String,
    val content: String
)