package com.example.fitnessapp.android

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class workoutShoulders : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_shoulders)

        val home = findViewById<ImageView>(R.id.appIcon)
        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val lateralRaise = findViewById<TextView>(R.id.WorkoutDescription1)
        lateralRaise.text = getString(R.string.workout_sideDumbbellRaise) +
                System.getProperty("line.separator") +
                getString(R.string._3_sets_8_reps)
        lateralRaise.setOnClickListener {
            val intent = Intent(this, sideRaise::class.java)
            startActivity(intent)
        }

        val frontDumbbellRaise = findViewById<TextView>(R.id.WorkoutDescription2)
        frontDumbbellRaise.text = getString(R.string.workout_frontDumbbellRaise) +
                System.getProperty("line.separator") +
                getString(R.string._3_sets_10_reps)
        frontDumbbellRaise.setOnClickListener {
            val intent = Intent(this, frontRaise::class.java)
            startActivity(intent)
        }

        val dumbbellPress = findViewById<TextView>(R.id.WorkoutDescription3)
        dumbbellPress.text = getString(R.string.workout_shoulderPress) +
                System.getProperty("line.separator") +
                getString(R.string._3_sets_8_reps) +
                " " +
                getString(R.string.double_dropset)
        dumbbellPress.setOnClickListener {
            val intent = Intent(this, com.example.fitnessapp.android.dumbbellPress::class.java)
            startActivity(intent)
        }
    }
}