package com.khun.composeopenai.repository

import android.content.Context
import com.khun.composeopenai.BuildConfig
import com.khun.composeopenai.data.local.AnswerDao
import com.khun.composeopenai.data.local.AnswerEntity
import com.khun.composeopenai.data.remote.OpenAIService
import com.khun.composeopenai.model.Answer
import com.khun.composeopenai.model.BaseModel
import com.khun.composeopenai.model.Message
import com.khun.composeopenai.model.Question
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.io.InputStream
import java.util.Properties
import javax.inject.Inject


class AppRepository @Inject constructor(
    private val context: Context,
    private val apiService: OpenAIService,
    private val ansDao: AnswerDao
) {
    suspend fun askQuestion(prevQuestions: List<Message>, question: String): BaseModel<Answer> {

        try {
            apiService.askQuestion(
                "Bearer ${BuildConfig.API_KEY}",
                question = Question(
                    messages = prevQuestions + Message(
                        role = "user",
                        content = question
                    )
                )
            )
                .also { response ->
                    return if (response.isSuccessful) {
                        BaseModel.Success(data = response.body()!!)
                    } else {
                        BaseModel.Error(response.errorBody()?.toString().toString())
                    }
                }
        } catch (e: Exception) {
            return BaseModel.Error(e.message.toString())
        }
    }

    suspend fun getMessages(): Flow<List<Message>> {
        return ansDao.getAnswer().map { value ->
            value.map { entity ->
                Message(role = entity.role, content = entity.content)
            }
        }
    }

    suspend fun addAnswer(answer: Message) {
        ansDao.addAnswer(AnswerEntity(role = answer.role, content = answer.content))
    }
}