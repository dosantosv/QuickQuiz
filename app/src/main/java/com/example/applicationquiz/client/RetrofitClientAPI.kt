package com.example.applicationquiz.client

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientAPI private constructor() {
    companion object {
        private lateinit var _instance: Retrofit
        private fun getRetrofitInstance() : Retrofit {

            val httpClient = OkHttpClient.Builder().build()

            if(!Companion::_instance.isInitialized) {
                synchronized(RetrofitClientAPI::class.java) {
                    _instance = Retrofit.Builder()
                        .baseUrl("https://opentdb.com/")
                        .client(httpClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
            }

            return _instance
        }
    }
}