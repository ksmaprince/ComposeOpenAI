package com.khun.composeopenai.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khun.composeopenai.model.BaseModel
import com.khun.composeopenai.model.Message
import com.khun.composeopenai.repository.AppRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class AppViewModel @Inject constructor(private val appRepository: AppRepository) : ViewModel() {


    private val _messages: MutableStateFlow<List<Message>> = MutableStateFlow(emptyList())
    val messages = _messages.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading get() = _loading.asStateFlow()

    init {
        viewModelScope.launch {
            appRepository.getMessages().collect { data ->
                _messages.update { data }
            }
        }
    }

    fun askQuestion(question: String) {
        viewModelScope.launch {
            appRepository.askQuestion(
                prevQuestions = messages.value,
                question = question
            ).also { baseModel ->
                _loading.update { false }
                when (baseModel) {
                    is BaseModel.Success -> {
                        appRepository.addAnswer(
                            answer = Message(
                                role = "assistant",
                                content = baseModel.data.choices.first().message.content
                            )
                        )
                    }

                    is BaseModel.Error -> {
                        Log.d("Error", baseModel.message)
                    }

                    else -> {}
                }
            }
        }
    }
}