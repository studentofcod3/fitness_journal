package com.example.fitnessjournal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var workoutItemAdapter: WorkoutItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var workoutItems: RecyclerView = findViewById(R.id.rvWorkoutItems)
        workoutItemAdapter = WorkoutItemAdapter(mutableListOf())

        workoutItems.adapter = workoutItemAdapter
        workoutItems.layoutManager = LinearLayoutManager(this)


        val button: Button = findViewById(R.id.btn_new_workout)
        button.setOnClickListener {
            startActivity(NewWorkoutActivity.createIntent(this))
        }
    }
}