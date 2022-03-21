package com.gmail.weronikapios7.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.gmail.weronikapios7.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityQuizQuestionsBinding
    private var currentPosition = 1
    private var questionsList: ArrayList<Question>? = null
    private var selectedOptionPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.optionOne.setOnClickListener(this)
        binding.optionTwo.setOnClickListener(this)
        binding.optionThree.setOnClickListener(this)
        binding.optionFour.setOnClickListener(this)

        binding.btnSubmit.setOnClickListener(this)

        questionsList = Constants.getQuestions()
        setQuestion()
    }

    private fun setQuestion() {

        val question: Question = questionsList!![currentPosition - 1]
        binding.progressBar.progress = currentPosition
        binding.ivImage.setImageResource(question.image)
        binding.tvProgress.text = "$currentPosition / ${binding.progressBar.max}"
        binding.tvQuestion.text = question.question
        binding.optionOne.text = question.optionOne
        binding.optionTwo.text = question.optionTwo
        binding.optionThree.text = question.optionThree
        binding.optionFour.text = question.optionFour

        if (currentPosition == questionsList!!.size) {
            binding.btnSubmit.text = "FINISH"
        }


    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        binding.optionOne.let {
            options.add(0, it)
        }
        binding.optionTwo.let {
            options.add(1, it)
        }
        binding.optionThree.let {
            options.add(2, it)
        }
        binding.optionFour.let {
            options.add(3, it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.option_border_bg
            )
        }

    }

    private fun selectedOptionView(tv: TextView, selectedOptionNo: Int) {
        defaultOptionsView()
        selectedOptionPosition = selectedOptionNo
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.option_one -> {
                binding.optionOne.let { selectedOptionView(it, 1) }
            }
            R.id.option_two -> {
                binding.optionTwo.let { selectedOptionView(it, 2) }
            }
            R.id.option_three -> {
                binding.optionThree.let { selectedOptionView(it, 3) }
            }
            R.id.option_four -> {
                binding.optionFour.let { selectedOptionView(it, 4) }
            }
            R.id.btn_submit -> { //TODO implement }
            }
        }
    }
}