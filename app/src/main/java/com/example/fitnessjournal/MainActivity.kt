package com.example.fitnessjournal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitnessjournal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var workoutItemAdapter: WorkoutItemAdapter
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            btnNewWorkout.setOnClickListener {
                startActivity(NewWorkoutActivity.createIntent(this@MainActivity))
            }
            rvWorkoutItems.adapter = workoutItemAdapter
            rvWorkoutItems.layoutManager = LinearLayoutManager(this@MainActivity)
        }

        workoutItemAdapter = WorkoutItemAdapter(mutableListOf())
    }
}