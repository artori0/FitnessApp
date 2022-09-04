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

class workoutBack : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_back)

        val home = findViewById<ImageView>(R.id.appIcon)
        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val hipThrusts = findViewById<TextView>(R.id.WorkoutDescription1)
        hipThrusts.text = getString(R.string.workout_barbellRow) +
                System.getProperty("line.separator") +
                getString(R.string._5_sets_12_reps)
        hipThrusts.setOnClickListener {
            val intent = Intent(this, barbellRow::class.java)
            startActivity(intent)
        }

        val dumbbellRows = findViewById<TextView>(R.id.WorkoutDescription2)
        dumbbellRows.text = getString(R.string.workout_dumbbellRow) +
                System.getProperty("line.separator") +
                getString(R.string._6_sets_12_reps)
        dumbbellRows.setOnClickListener {
            val intent = Intent(this, dumbbellRow::class.java)
            startActivity(intent)
        }

        val pushup = findViewById<TextView>(R.id.WorkoutDescription3)
        pushup.text = getString(R.string.workout_pushups) +
                System.getProperty("line.separator") +
                getString(R.string._3_sets_10_reps)
    }
}