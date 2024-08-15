package com.example.applicationquiz.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.applicationquiz.databinding.ActivityStartBinding
import com.example.applicationquiz.views.QuestionActivity

class StartActivity : AppCompatActivity() {

    private lateinit var  _binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        _binding.btnEnter.setOnClickListener { enter() }

    }

    private fun enter() {
        if (_binding.editName.text == null || _binding.editName.text.toString() == "") {
            Toast.makeText(this, "Digite o nome corretamente!", Toast.LENGTH_SHORT).show()
            return
        }

        val username : String= _binding.editName.text.toString()

        val intent = Intent(this, QuestionActivity::class.java)
        intent.putExtra("username", username)

        startActivity(intent)

        Toast.makeText(this, "${username} logado com sucesso!", Toast.LENGTH_SHORT).show()
    }




}