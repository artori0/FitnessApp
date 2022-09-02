package com.example.fitnessapp.android

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView

class workoutLegs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_legs)

        val home = findViewById<ImageView>(R.id.appIcon)
        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val squats = findViewById<TextView>(R.id.WorkoutDescription1)
        squats.setOnClickListener {
            val intent = Intent(this, com.example.fitnessapp.android.benchpress::class.java)
            startActivity(intent)
        }
    }
}