package com.khun.composeopenai.data.remote

import com.khun.composeopenai.model.Answer
import com.khun.composeopenai.model.Question
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface OpenAIService {
    @POST("completions")
    suspend fun askQuestion(
        @Header("Authorization") apiKey: String,
        @Body question: Question
    ): Response<Answer>
}