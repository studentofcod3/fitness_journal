package com.example.fitnessjournal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnessjournal.databinding.ActivityNewWorkoutBinding

class NewWorkoutActivity : AppCompatActivity() {
    private val binding: ActivityNewWorkoutBinding by lazy {
        ActivityNewWorkoutBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

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
//      TODO: validation
//        val validated = true
//        if(!validated){
//            return
//        }

//        TODO: send this info to workout success view
        with(binding){
            println(exerciseName.text.toString())
            println(exerciseSetNumber.text.toString().toInt())
            println(exerciseWeight.text.toString().toFloat())
            println(exerciseExtraNotes.text.toString())
        }

//        val payload = WorkoutItem(
//            title = titleString,
//            sets = numberSetsInt,
//            mass = massInt,
//            extraNotes = extraNotesString
//        )
//        addWorkoutItem(payload)

        redirectSuccess()
    }

    private fun redirectSuccess(){
        startActivity(WorkoutSuccessActivity.createIntent(this))
    }

// TODO
//    fun addWorkoutItem(item: WorkoutItem) {
//        workoutItemsList.add(item)
//        notifyItemInserted(itemCount - 1)
//    }
}