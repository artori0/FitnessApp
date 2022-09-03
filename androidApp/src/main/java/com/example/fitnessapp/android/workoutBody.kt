package com.example.fitnessapp.android

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView

class workoutBody : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_body)

        val home = findViewById<ImageView>(R.id.appIcon)
        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val squats = findViewById<TextView>(R.id.WorkoutDescription1)
        squats.text = getString(R.string.workout_squats) +
                System.getProperty("line.separator") +
                getString(R.string._4_sets_10_reps)
        squats.setOnClickListener {
            val intent = Intent(this, com.example.fitnessapp.android.squats::class.java)
            startActivity(intent)
        }

        val bench = findViewById<TextView>(R.id.WorkoutDescription2)
        bench.text = getString(R.string.workout_benchpress) +
                System.getProperty("line.separator") +
                getString(R.string._3_sets_10_reps)
        bench.setOnClickListener {
            val intent = Intent(this, benchpress::class.java)
            startActivity(intent)
        }

        val pullup = findViewById<TextView>(R.id.WorkoutDescription3)
        pullup.text = getString(R.string.workout_pullups) +
                System.getProperty("line.separator") +
                getString(R.string._3_sets_10_reps)

        val shoulderPress = findViewById<TextView>(R.id.WorkoutDescription4)
        shoulderPress.text = getString(R.string.workout_shoulderPress) +
                System.getProperty("line.separator") +
                getString(R.string._3_sets_8_reps) +
                " " +
                getString(R.string.double_dropset)
        shoulderPress.setOnClickListener {
            val intent = Intent(this, benchpress::class.java)
            startActivity(intent)
        }

    }
}