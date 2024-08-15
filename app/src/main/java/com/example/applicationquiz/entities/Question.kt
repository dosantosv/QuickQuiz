package com.example.applicationquiz.entities

import com.google.gson.annotations.SerializedName

class Question {

    @SerializedName("question ")
    lateinit var question: String

    @SerializedName("category")
    lateinit var category: String

    @SerializedName("correct_answer")
    lateinit var correct_answer: String

    @SerializedName("incorrect_answers")
    lateinit var incorrect_answers: List<String>

}