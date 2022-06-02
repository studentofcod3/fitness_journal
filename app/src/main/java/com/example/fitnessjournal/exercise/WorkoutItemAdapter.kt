package com.example.fitnessjournal.exercise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessjournal.R

class WorkoutItemAdapter(
    public var workoutItemsList: List<WorkoutItem>,
    private val listener: WorkoutListener,
) : RecyclerView.Adapter<WorkoutItemAdapter.WorkoutItemViewHolder>() {

    interface WorkoutListener {
        fun onWorkoutClicked(position: Int)
    }

    class WorkoutItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val exerciseItemTitle: TextView = itemView.findViewById(R.id.tvExerciseItemTitle)
        val cbExerciseItem: CheckBox = itemView.findViewById(R.id.cbExerciseItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutItemViewHolder {
        val workoutItemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_workout,
            parent,
            false
        )
        return WorkoutItemViewHolder(workoutItemView)
    }

    override fun onBindViewHolder(
        holder: WorkoutItemViewHolder,
        position: Int
    ) {
        val currentWorkoutItem = workoutItemsList[position]
        holder.apply {
            exerciseItemTitle.text = currentWorkoutItem.title
//            cbExerciseItem.isChecked = currentWorkoutItem.isChecked
//            cbExerciseItem.setOnCheckedChangeListener { _, b ->
//                currentWorkoutItem.isChecked = !currentWorkoutItem.isChecked
//            }
            itemView.setOnClickListener {
                listener.onWorkoutClicked(position = position)
            }
        }
    }

    override fun getItemCount(): Int =
        workoutItemsList.size
}
