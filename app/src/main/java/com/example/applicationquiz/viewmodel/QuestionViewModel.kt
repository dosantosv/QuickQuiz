package com.example.applicationquiz.viewmodel

import FunctionResponseData
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.applicationquiz.entities.Question
import com.example.applicationquiz.remote.QuestionRepository
import com.example.applicationquiz.remote.listener.APIListener

class QuestionViewModel(application: Application) : AndroidViewModel(application) {

    private val questionRepository = QuestionRepository(application.applicationContext)

    private val _questions = MutableLiveData<FunctionResponseData<Question>>()
    val questions: LiveData<FunctionResponseData<Question>> = _questions

    fun getQuestions(amount: Int) {
        questionRepository.getQuestions(object : APIListener<Question> {
            override fun onSucess(result: Question) {
                _questions.value = FunctionResponseData.Success()
                _questions.value?.responseData = result
            }

            override fun onFailure(message: String) {
                _questions.value?.message = message
                _questions.value?.sucess = false
            }

        })
    }
}