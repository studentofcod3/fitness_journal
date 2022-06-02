package com.example.fitnessjournal.exercise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessjournal.R

class ExerciseItemAdapter(
    public var exerciseItemsList: List<ExerciseItem>,
    private val listener: ExerciseListener,
) : RecyclerView.Adapter<ExerciseItemAdapter.ExerciseItemViewHolder>() {

    interface ExerciseListener {
        fun onExerciseClicked(position: Int)
    }

    class ExerciseItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val exerciseItemTitle: TextView = itemView.findViewById(R.id.tvExerciseItemTitle)
        val cbExerciseItem: CheckBox = itemView.findViewById(R.id.cbExerciseItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseItemViewHolder {
        val exerciseItemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_exercise,
            parent,
            false
        )
        return ExerciseItemViewHolder(exerciseItemView)
    }

    override fun onBindViewHolder(
        holder: ExerciseItemViewHolder,
        position: Int
    ) {
        val currentExerciseItem = exerciseItemsList[position]
        holder.apply {
            exerciseItemTitle.text = currentExerciseItem.title
//            cbExerciseItem.isChecked = currentExerciseItem.isChecked
//            cbExerciseItem.setOnCheckedChangeListener { _, b ->
//                currentExerciseItem.isChecked = !currentExerciseItem.isChecked
//            }
            itemView.setOnClickListener {
                listener.onExerciseClicked(position = position)
            }
        }
    }

    override fun getItemCount(): Int =
        exerciseItemsList.size
}
