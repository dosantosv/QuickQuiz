package com.example.applicationquiz.remote.service

import com.example.applicationquiz.entities.Question
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

interface QuestionService {

    @GET("api.php?amount=1")
    @FormUrlEncoded
    fun getQuestions() : Call<Question>

}