package com.example.applicationquiz.views

import android.content.Intent
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.applicationquiz.User
import com.example.applicationquiz.databinding.ActivityQuestionBinding
import com.example.applicationquiz.entities.Question
import com.example.applicationquiz.view.MockQuestions
import com.example.applicationquiz.viewmodel.QuestionViewModel

class QuestionActivity: AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private lateinit var viewModel: QuestionViewModel
    private lateinit var user: User
    private lateinit var _binding: ActivityQuestionBinding
    private var currentQuestion: String = ""
    private var correctAnswer: String = ""
    private var answers: ArrayList<String> = ArrayList()
    private var _numberPage = 1
    private var currentResponse: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val username = intent.getStringExtra("username") ?: ""
        user = User(username)

        observe()

        getQuestionsAndAnswers()

        _binding.btnPular.setOnClickListener { skipQuestion() }
        _binding.btnOk.setOnClickListener { onClickButtonOk() }

        _binding.radiobtnResponse1.setOnCheckedChangeListener(this)
        _binding.radiobtnResponse2.setOnCheckedChangeListener(this)
        _binding.radiobtnResponse3.setOnCheckedChangeListener(this)
        _binding.radiobtnResponse4.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        currentResponse = buttonView.text.toString()
    }

    private fun observe() {
        viewModel.questions.observe(this) {
            if(it.sucess) {
                it.responseData?.let { it1 -> getQuestions(it1) }
            }

            Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun getQuestions(question: Question) {
        for (question in question.incorrect_answers)
            answers.add(question)

        correctAnswer = question.correct_answer

        answers.add(correctAnswer)

        currentQuestion = question.question
    }

    private fun getQuestionsAndAnswers()
    {
        _binding.textQuestion.text = currentQuestion
        _binding.radiobtnResponse1.text = answers[0]
        _binding.radiobtnResponse2.text = answers[1]
        _binding.radiobtnResponse3.text = answers[2]
        _binding.radiobtnResponse4.text = answers[3]

        if(_numberPage == 5)
            getConclusionActivity()
    }

    private fun skipQuestion() {
        _numberPage++

        viewModel.getQuestions(1)

        getQuestionsAndAnswers()
        cleanRadioButtons()
    }

    private fun onClickButtonOk() {

        if(currentResponse == correctAnswer)
            user.points++

        _numberPage++

        viewModel.getQuestions(1)

        getQuestionsAndAnswers()
        cleanRadioButtons()
    }

    private fun getConclusionActivity() {
        val intent = Intent(this, ConclusionActivity::class.java)
        intent.putExtra("userPoints", user.points)
        intent.putExtra("username", user.name)

        startActivity(intent)
    }

    private fun cleanRadioButtons() {
        _binding.radiobtnResponse1.isChecked = false
        _binding.radiobtnResponse2.isChecked = false
        _binding.radiobtnResponse3.isChecked = false
        _binding.radiobtnResponse4.isChecked = false
    }



}