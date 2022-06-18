package com.example.fitnessjournal.exercise

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnessjournal.R
import com.example.fitnessjournal.databinding.ActivityNewExerciseBinding

class NewExerciseActivity : AppCompatActivity() {
    private val binding: ActivityNewExerciseBinding by lazy {
        ActivityNewExerciseBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val button: Button = findViewById(R.id.btn_save_exercise)
        button.setOnClickListener {
            handleNewExerciseSubmission()
        }
    }

    companion object {
        fun createIntent(ctx: Context): Intent =
            Intent(ctx, NewExerciseActivity::class.java)
    }

    private fun handleNewExerciseSubmission() {
        with(binding) {
            println(exerciseName.text.toString())
            println(exerciseSetNumber.text.toString().toInt())
            println(exerciseWeight.text.toString().toFloat())
            println(exerciseExtraNotes.text.toString())
        }

        redirectSuccess()
    }

    private fun redirectSuccess() {
        startActivity(ExerciseSuccessActivity.createIntent(this))
    }
}
