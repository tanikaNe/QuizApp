package com.gmail.weronikapios7.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gmail.weronikapios7.quizapp.databinding.ActivityMainBinding

//TODO use a navigation component and make ResultActivity and QuizQuestionsActivity destinations instead of activities
//TODO read questions from a file or firebase
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnStart.setOnClickListener {
            if (binding.etName.text!!.isEmpty()){
                Toast.makeText(this, "Please enter your name.", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, binding.etName.text.toString())
                startActivity(intent)
                finish() //close this activity
            }
        }
    }
}