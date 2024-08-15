package com.example.applicationquiz.views

import android.content.Intent
import android.os.Bundle
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import com.example.applicationquiz.User
import com.example.applicationquiz.databinding.ActivityQuestionBinding
import com.example.applicationquiz.view.MockQuestions

class QuestionActivity: AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private lateinit var user: User
    private lateinit var _binding: ActivityQuestionBinding
    private var _numberPage = 1
    private var currentResponse: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val username = intent.getStringExtra("username") ?: ""
        user = User(username)

        getQuestionsToNumberPage()

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

    private fun getQuestionsToNumberPage()
    {
        val questionPageOne = MockQuestions.responseOne["Tem entre 4 a 6 litros. São retirados 450 mililitros"]
        val questionPageTwo = MockQuestions.responseTwo["Descartes"]
        val questionPageThree = MockQuestions.responseThree["Brasil"]
        val questionPageFour = MockQuestions.responseFour["Vaticano e Rússia"]

        when (_numberPage) {
            1 -> {
                _binding.textQuestion.text = MockQuestions.questionOne
                if(questionPageOne != null) {
                    _binding.radiobtnResponse1.text = questionPageOne[0]
                    _binding.radiobtnResponse2.text = questionPageOne[1]
                    _binding.radiobtnResponse3.text = questionPageOne[2]
                    _binding.radiobtnResponse4.text = questionPageOne[3]
                }
            }
            2 -> {
                _binding.textQuestion.text = MockQuestions.questionTwo
                if(questionPageTwo != null) {
                    _binding.radiobtnResponse1.text = questionPageTwo[0]
                    _binding.radiobtnResponse2.text = questionPageTwo[1]
                    _binding.radiobtnResponse3.text = questionPageTwo[2]
                    _binding.radiobtnResponse4.text = questionPageTwo[3]
                }
            }
            3 -> {
                _binding.textQuestion.text = MockQuestions.questionThree
                if(questionPageThree != null) {
                    _binding.radiobtnResponse1.text = questionPageThree[0]
                    _binding.radiobtnResponse2.text = questionPageThree[1]
                    _binding.radiobtnResponse3.text = questionPageThree[2]
                    _binding.radiobtnResponse4.text = questionPageThree[3]
                }
            }
            4 -> {
                _binding.textQuestion.text = MockQuestions.questionFour
                if(questionPageFour != null) {
                    _binding.radiobtnResponse1.text = questionPageFour[0]
                    _binding.radiobtnResponse2.text = questionPageFour[1]
                    _binding.radiobtnResponse3.text = questionPageFour[2]
                    _binding.radiobtnResponse4.text = questionPageFour[3]
                }
            }
            5 -> getConclusionActivity()
        }
    }

    private fun skipQuestion() {
        _numberPage++

        getQuestionsToNumberPage()
        cleanRadioButtons()
    }

    private fun onClickButtonOk() {
        when(_numberPage) {
            1 -> if (currentResponse == "Tem entre 4 a 6 litros. São retirados 450 mililitros") {
                user.points++
            }
            2 -> if (currentResponse == "Descartes") {
                user.points++
            }
            3 -> if (currentResponse == "Brasil") {
                user.points++
            }
            4 -> if (currentResponse == "Vaticano e Rússia") {
                user.points++
            }
        }
        _numberPage++
        getQuestionsToNumberPage()
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