package com.example.fitnessapp.android

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class workoutArms : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_arms)

        val home = findViewById<ImageView>(R.id.appIcon)
        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val bicep = findViewById<TextView>(R.id.WorkoutDescription1)
        bicep.text = getString(R.string.workout_bicep) +
                System.getProperty("line.separator") +
                getString(R.string._4_sets_10_reps) +
                " " +
                getString(R.string.double_dropset)
        bicep.setOnClickListener {
            val intent = Intent(this, bicepCurls::class.java)
            startActivity(intent)
        }

        val preacher = findViewById<TextView>(R.id.WorkoutDescription2)
        preacher.text = getString(R.string.workout_preacherCurl) +
                System.getProperty("line.separator") +
                getString(R.string._4_sets_12_reps) +
                " " +
                getString(R.string.workout_pause)
        preacher.setOnClickListener {
            val intent = Intent(this, preacherCurls::class.java)
            startActivity(intent)
        }

        val hammer = findViewById<TextView>(R.id.WorkoutDescription3)
        hammer.text = getString(R.string.workout_hammerCurl) +
                System.getProperty("line.separator") +
                getString(R.string._4_sets_10_reps)
        hammer.setOnClickListener {
            val intent = Intent(this, hammerCurls::class.java)
            startActivity(intent)
        }

    }

}
