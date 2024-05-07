package com.khun.composeopenai.data.remote

import com.khun.composeopenai.model.Answer
import com.khun.composeopenai.model.Question
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

//Replace Yor OpenAI Key will be here
const val APIKEY = "sk-proj-oQcOO5Taa7yqRHKDtMomT3BlbkFJIE6MldhRlrNIHTv3bkrn"
interface OpenAIService {
    @POST("completions")
    @Headers("Authorization: Bearer $APIKEY", "Content-Type: application/json")
    suspend fun askQuestion(
        @Body question: Question
    ): Response<Answer>
}