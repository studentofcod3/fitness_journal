package com.example.fitnessjournal

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessjournal.databinding.ActivityMainBinding
import com.example.fitnessjournal.exercise.NewExerciseActivity
import com.example.fitnessjournal.exercise.ExerciseItem
import com.example.fitnessjournal.exercise.ExerciseItemAdapter

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var adapter: ExerciseItemAdapter

    private val exercises = listOf(
        ExerciseItem(
            title = "Crunches",
            sets = 5,
            mass = 4f,
            extraNotes = "nothing special"
        ),
        ExerciseItem(
            title = "Bench Press",
            sets = 5,
            mass = 4f,
            extraNotes = "nothing special"
        ),
        ExerciseItem(
            title = "lat pull downs",
            sets = 5,
            mass = 4f,
            extraNotes = "nothing special"
        ),
        ExerciseItem(
            title = "shoulder press",
            sets = 5,
            mass = 4f,
            extraNotes = "nothing special"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        adapter = ExerciseItemAdapter(
            exerciseItemsList = emptyList(),
            listener = object : ExerciseItemAdapter.ExerciseListener {
                override fun onExerciseClicked(position: Int) {
                    Toast
                        .makeText(this@MainActivity, "item ${exercises[position].title} was clicked", Toast.LENGTH_SHORT)
                        .show()
//                    TODO open detail activity for item $position
                }
            }
        )
        with(binding) {
            rvExercises.apply {
                adapter = this@MainActivity.adapter
                layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            }
            btnAddExercise.setOnClickListener {
                startActivity(NewExerciseActivity.createIntent(this@MainActivity))
            }
        }

        loadedData(exercises)
    }

    private fun loadedData(list: List<ExerciseItem>) {
        adapter.exerciseItemsList = list
        adapter.notifyItemRangeInserted(0, list.size)
    }

//   TODO
//    fun deleteSelectedExerciseItems(){
//        exerciseItemsList.removeAll{
//            item -> item.isChecked
//        }
//        notifyDataSetChanged()
//    }
}
