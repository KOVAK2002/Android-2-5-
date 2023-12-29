package com.example.yourpackage

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lv21.R

class MainActivity : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var backButton: Button
    private lateinit var resultTextView: TextView

    private val questions = listOf(
        R.string.question_1,
        R.string.question_2,
        R.string.question_3,
        R.string.question_4,
        R.string.question_5
    )

    private var currentQuestionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionTextView = findViewById(R.id.questionTextView)
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        nextButton = findViewById(R.id.nextButton)
        backButton = findViewById(R.id.backButton)
        resultTextView = findViewById(R.id.resultTextView)

        displayQuestion()

        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }
        nextButton.setOnClickListener { nextQuestion() }
        backButton.setOnClickListener { previousQuestion() }

        // Logiranje promjena u životnom ciklusu
        Log.i("Lifecycle", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Lifecycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Lifecycle", "onRestart")
    }

    private fun displayQuestion() {
        questionTextView.setText(questions[currentQuestionIndex])
        trueButton.isEnabled = true
        falseButton.isEnabled = true
        nextButton.visibility = View.GONE
        resultTextView.text = ""
    }

    private fun checkAnswer(userAnswer: Boolean) {
        // Implementacija provjere odgovora

        trueButton.isEnabled = false
        falseButton.isEnabled = false
        nextButton.visibility = View.VISIBLE
    }

    private fun nextQuestion() {
        currentQuestionIndex = (currentQuestionIndex + 1) % questions.size
        displayQuestion()
    }

    private fun previousQuestion() {
        // Implementacija za povratak na prethodno pitanje
        // Ovdje bi trebalo biti dodatno rukovanje kako bi se spriječilo
        // izlazak izvan granica liste pitanja.
    }
}
