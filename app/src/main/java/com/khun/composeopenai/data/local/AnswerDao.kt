package com.khun.composeopenai.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AnswerDao {
    @Insert
    suspend fun addAnswer(answerEntity: AnswerEntity)

    @Query("SELECT * FROM `answers`")
    fun getAnswer(): Flow<List<AnswerEntity>>
}