package com.example.fitnessjournal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WorkoutItemAdapter(
    private val workoutItemsList: MutableList<WorkoutItem>
) : RecyclerView.Adapter<WorkoutItemAdapter.WorkoutItemViewHolder>(){
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

    override fun onBindViewHolder(holder: WorkoutItemViewHolder, position: Int) {
        val currentWorkoutItem = workoutItemsList[position]
        holder.apply{
            exerciseItemTitle.text = currentWorkoutItem.title
            cbExerciseItem.isChecked = currentWorkoutItem.isChecked
            cbExerciseItem.setOnCheckedChangeListener { _, b ->
                currentWorkoutItem.isChecked = !currentWorkoutItem.isChecked
            }
        }
    }

    override fun getItemCount(): Int {
        return workoutItemsList.size
    }

    fun addWorkoutItem(item: WorkoutItem) {
        workoutItemsList.add(item)
        notifyItemInserted(itemCount - 1)
    }

    // TODO: Implement functionality to use this
    fun deleteSelectedWorkoutItems(){
        workoutItemsList.removeAll{
            item -> item.isChecked
        }
        notifyDataSetChanged()
    }
}