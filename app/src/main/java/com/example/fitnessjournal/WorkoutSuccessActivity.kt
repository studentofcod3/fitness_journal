package com.example.fitnessjournal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import nl.dionsegijn.konfetti.xml.KonfettiView
import java.util.concurrent.TimeUnit

class WorkoutSuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_success)

        val party = Party(
            speed = SPEED,
            maxSpeed = MAX_SPEED,
            damping = DAMPING,
            spread = SPREAD,
            colors = listOf(GREEN, RED, BLUE, PURPLE),
            emitter = Emitter(duration = DURATION, TimeUnit.MILLISECONDS).max(DURATION.toInt()),
            position = Position.Relative(X, Y)
        )

        val konfettiView: KonfettiView = findViewById(R.id.konfetti)

        konfettiView.start(party)
    }

    companion object {
        private const val SPEED = 0f
        private const val MAX_SPEED = 30f
        private const val DAMPING = 0.9f
        private const val SPREAD = 360
        private const val DURATION = 100L
        private const val X = 0.5
        private const val Y = 0.3

        private const val GREEN = 0xfce18a
        private const val RED = 0xff726d
        private const val BLUE = 0xf4306d
        private const val PURPLE = 0xb48def

        fun createIntent(ctx: Context): Intent =
            Intent(ctx, WorkoutSuccessActivity::class.java)
    }
}
