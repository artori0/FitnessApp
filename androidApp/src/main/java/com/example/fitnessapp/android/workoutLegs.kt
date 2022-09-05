package com.example.fitnessapp.android

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class workoutLegs : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_legs)

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

        val hipThrusts = findViewById<TextView>(R.id.WorkoutDescription2)
        hipThrusts.text = getString(R.string.workout_hipthrusts) +
                System.getProperty("line.separator") +
                getString(R.string._4_sets_15_reps)
        hipThrusts.setOnClickListener {
            val intent = Intent(this, com.example.fitnessapp.android.hipThrusts::class.java)
            startActivity(intent)
        }

        val splitSquats = findViewById<TextView>(R.id.WorkoutDescription3)
        splitSquats.text = getString(R.string.workout_splitSquats) +
                System.getProperty("line.separator") +
                getString(R.string._4_sets_12_reps) +
                " " +
                getString(R.string.each_side)
        splitSquats.setOnClickListener {
            val intent = Intent(this, com.example.fitnessapp.android.splitSquats::class.java)
            startActivity(intent)
        }

        val calfRaise = findViewById<TextView>(R.id.WorkoutDescription4)
        calfRaise.text = getString(R.string.workout_calfRaise) +
                System.getProperty("line.separator") +
                getString(R.string._4_sets_6_reps)
        calfRaise.setOnClickListener {
            val intent = Intent(this, com.example.fitnessapp.android.calfRaise::class.java)
            startActivity(intent)
        }

        val seatedCalfRaise = findViewById<TextView>(R.id.WorkoutDescription5)
        seatedCalfRaise.text = getString(R.string.workout_seatedCalfRaise) +
                System.getProperty("line.separator") +
                getString(R.string._4_sets_15_reps)
        seatedCalfRaise.setOnClickListener {
            val intent = Intent(this, com.example.fitnessapp.android.seatedCalfRaise::class.java)
            startActivity(intent)
        }
    }
}