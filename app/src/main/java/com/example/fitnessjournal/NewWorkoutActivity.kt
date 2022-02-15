package com.example.fitnessjournal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class NewWorkoutActivity : AppCompatActivity() {
    private lateinit var workoutItemAdapter: WorkoutItemAdapter

    private lateinit var title: EditText
    private lateinit var sets: EditText
    private lateinit var mass: EditText
    private lateinit var extraNotes: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_workout)

        workoutItemAdapter = WorkoutItemAdapter(mutableListOf())

        val button: Button = findViewById(R.id.btn_save_exercise)
        button.setOnClickListener {
            handleNewWorkoutSubmission()
        }
    }

    companion object {
        fun createIntent(ctx : Context): Intent =
            Intent(ctx, NewWorkoutActivity::class.java)
    }

    private fun handleNewWorkoutSubmission() {
        val validated = true
        if(!validated){
            return
        }

        title = findViewById(R.id.exercise_name)
        sets = findViewById(R.id.exercise_set_number)
        mass = findViewById(R.id.exercise_weight)
        extraNotes = findViewById(R.id.exercise_extra_notes)


        val titleString: String = title.text.toString()
        val numberSetsInt: Int = sets.text.toString().toInt()
        val massInt: Float = mass.toString().toFloat()
        val extraNotesString: String = extraNotes.toString()

        val payload = WorkoutItem(
            title = titleString,
            sets = numberSetsInt,
            mass = massInt,
            extraNotes = extraNotesString
        )
        workoutItemAdapter.addWorkoutItem(payload)

        redirectSuccess()
    }

    private fun redirectSuccess(){
        startActivity(WorkoutSuccessActivity.createIntent(this))
    }
}