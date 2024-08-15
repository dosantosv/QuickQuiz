package com.example.applicationquiz.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.applicationquiz.R
import com.example.applicationquiz.databinding.ActivityConclusionBinding

class ConclusionActivity: AppCompatActivity() {

    private lateinit var _binding: ActivityConclusionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val currentUserPoints = intent.getIntExtra("userPoints", 0)

        if(currentUserPoints > 2) {
            getConclusionActivitySuccessful(currentUserPoints)
            return
        }

        getConclusionActivityFail(currentUserPoints)

        val username = intent.getStringExtra("username") ?: ""

        _binding.btnReturn.setOnClickListener { onClickReturnButton(username) }

    }

    private fun getConclusionActivitySuccessful(currentUserPoints : Int) {
        _binding.imageNotice.setImageResource(R.drawable.baseline_celebration_24)
        _binding.textNotice.text = "Parabéns"
        _binding.textCount.text = "Voce concluiu com ${currentUserPoints} de 4 acertos"
    }

    private fun getConclusionActivityFail(currentUserPoints : Int) {
        _binding.imageNotice.setImageResource(R.drawable.baseline_error_24)
        _binding.textNotice.text = ":("
        _binding.textCount.text = "Voce concluiu com ${currentUserPoints} de 4 acertos"
    }

    private fun onClickReturnButton(username: String) {
        val intent = Intent(this, QuestionActivity::class.java)
        intent.putExtra("username", username)

        startActivity(intent)
    }
}