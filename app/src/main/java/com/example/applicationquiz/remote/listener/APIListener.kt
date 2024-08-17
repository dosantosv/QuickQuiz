package com.example.applicationquiz.remote.listener

interface APIListener<T> {

    fun onSucess(result: T)

    fun onFailure(message: String)
}