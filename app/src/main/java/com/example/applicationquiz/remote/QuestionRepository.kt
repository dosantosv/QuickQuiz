package com.example.applicationquiz.remote

import android.content.Context
import com.example.applicationquiz.entities.Question
import com.example.applicationquiz.remote.client.RetrofitClientAPI
import com.example.applicationquiz.remote.listener.APIListener
import com.example.applicationquiz.remote.service.QuestionService
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuestionRepository(val context: Context) {

    private val remote = RetrofitClientAPI.getService(QuestionService::class.java)

    fun getQuestions(listener: APIListener<Question>) {
        val call = remote.getQuestions()
        call.enqueue(object : Callback<Question> {
            override fun onResponse(call: Call<Question>, response: Response<Question>) {
                if(response.code() != 200)
                    failResponse(response.errorBody()!!.string())

                response.body()?.let { listener.onSucess(it) }
            }

            override fun onFailure(call: Call<Question>, t: Throwable) {
                failResponse("Um erro inesperado aconteceu. Tente novamente!")
            }

        })
    }

    private fun failResponse(message: String) : String {
        return Gson().fromJson(message, String::class.java)
    }

}