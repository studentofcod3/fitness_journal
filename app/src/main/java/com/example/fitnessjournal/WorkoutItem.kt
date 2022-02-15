package com.example.fitnessjournal

data class WorkoutItem (
    val title: String,
    val sets: Int,
    val mass: Float,
    val extraNotes: String,
    var isChecked: Boolean = false,
    )