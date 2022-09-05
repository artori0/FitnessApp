package com.example.fitnessapp.android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        val workoutButton = findViewById<Button>(R.id.workoutButton)
        workoutButton.setOnClickListener {
            val intent = Intent(this, workouts::class.java)
            startActivity(intent)
        }

        val timerButton = findViewById<Button>(R.id.timerButton)
        timerButton.setOnClickListener {
            val intent = Intent(this, timer::class.java)
            startActivity(intent)
        }

        val calorieButton = findViewById<Button>(R.id.calorieButton)
        calorieButton.setOnClickListener {
            val intent = Intent(this, calorieCounter::class.java)
            startActivity(intent)
        }

        val feedbackButton = findViewById<Button>(R.id.feedbackButton)
        feedbackButton.setOnClickListener {
            val intent = Intent(this, feedback::class.java)
            startActivity(intent)
        }

        val settingsButton = findViewById<Button>(R.id.settingsButton)
        settingsButton.setOnClickListener {
            val intent = Intent(this, settings::class.java)
            startActivity(intent)
        }

        val step = findViewById<Button>(R.id.stepButton)
        step.setOnClickListener {
            val intent = Intent(this, stepCounter::class.java)
            startActivity(intent)
        }

        val progressbar : ProgressBar = findViewById(R.id.progressBar)
        progressbar.setOnClickListener {
            val intent = Intent(this, workoutProgress::class.java)
            startActivity(intent)
        }
        progressbar.progress = 20
    }
}
