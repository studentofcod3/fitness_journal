package com.example.fitnessjournal.exercise

data class ExerciseItem(
    val title: String,
    val sets: Int,
    val mass: Float,
    val extraNotes: String,
    var isChecked: Boolean = false,
)
