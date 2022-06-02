package com.example.fitnessjournal

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessjournal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var adapter: WorkoutItemAdapter

    private val workouts = listOf(
        WorkoutItem(
            title = "Crunches",
            sets = 5,
            mass = 4f,
            extraNotes = "nothing special"
        ),
        WorkoutItem(
            title = "Bench Press",
            sets = 5,
            mass = 4f,
            extraNotes = "nothing special"
        ),
        WorkoutItem(
            title = "lat pull downs",
            sets = 5,
            mass = 4f,
            extraNotes = "nothing special"
        ),
        WorkoutItem(
            title = "shoulder press",
            sets = 5,
            mass = 4f,
            extraNotes = "nothing special"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        adapter = WorkoutItemAdapter(
            workoutItemsList = emptyList(),
            listener = object : WorkoutItemAdapter.WorkoutListener {
                override fun onWorkoutClicked(position: Int) {
                    Toast
                        .makeText(this@MainActivity, "item ${workouts[position].title} was clicked", Toast.LENGTH_SHORT)
                        .show()
//                    TODO open detail activity for item $position
                }
            }
        )
        with(binding) {
            rvWorkouts.apply {
                adapter = this@MainActivity.adapter
                layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            }
            btnAddWorkout.setOnClickListener {
                startNewWorkoutActivity()
            }
        }

        loadedData(workouts)
    }

    fun startNewWorkoutActivity(){
        startActivity(NewWorkoutActivity.createIntent(this@MainActivity))
    }

    private fun loadedData(list: List<WorkoutItem>) {
        adapter.workoutItemsList = list
        adapter.notifyItemRangeInserted(0, list.size)
    }

//   TODO
//    fun deleteSelectedWorkoutItems(){
//        workoutItemsList.removeAll{
//            item -> item.isChecked
//        }
//        notifyDataSetChanged()
//    }
}
