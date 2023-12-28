 package com.example.lv21


 import android.os.Bundle
 import android.view.View
 import android.widget.Button
 import android.widget.TextView
 import androidx.appcompat.app.AppCompatActivity

 class MainActivity : AppCompatActivity() {

     private lateinit var questionTextView: TextView
     private lateinit var trueButton: Button
     private lateinit var falseButton: Button
     private lateinit var nextButton: Button
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
         resultTextView = findViewById(R.id.resultTextView)

         displayQuestion()

         trueButton.setOnClickListener { checkAnswer(true) }
         falseButton.setOnClickListener { checkAnswer(false) }
         nextButton.setOnClickListener { nextQuestion() }
     }

     private fun displayQuestion() {
         questionTextView.setText(questions[currentQuestionIndex])
         trueButton.isEnabled = true
         falseButton.isEnabled = true
         nextButton.visibility = View.GONE
         resultTextView.text = ""
     }

     private fun checkAnswer(userAnswer: Boolean) {
         val correctAnswer = when (currentQuestionIndex) {
             0 -> true
             1 -> true
             2 -> true
             3 -> false
             4 -> false
             else -> false
         }

         if (userAnswer == correctAnswer) {
             resultTextView.setText(R.string.correct_answer)
         } else {
             resultTextView.setText(R.string.incorrect_answer)
         }

         trueButton.isEnabled = false
         falseButton.isEnabled = false
         nextButton.visibility = View.VISIBLE
     }

     private fun nextQuestion() {
         currentQuestionIndex = (currentQuestionIndex + 1) % questions.size
         displayQuestion()
     }
 }
