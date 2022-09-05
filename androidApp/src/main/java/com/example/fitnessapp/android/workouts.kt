package com.example.fitnessapp.android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnessapp.android.databinding.ActivityWorkoutsBinding

class workouts : AppCompatActivity() {

    private lateinit var binding: ActivityWorkoutsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWorkoutsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title

        val workoutArmsButton = findViewById<Button>(R.id.workoutArmsButton)
        val workoutBodyButton = findViewById<Button>(R.id.workoutBodyButton)
        val workoutLegsButton = findViewById<Button>(R.id.workoutLegsButton)
        val workoutAbsButton = findViewById<Button>(R.id.workoutAbsButton)
        val workoutBackButton = findViewById<Button>(R.id.workoutBackButton)
        val workoutShoulderButton = findViewById<Button>(R.id.workoutShoulderButton)

        workoutArmsButton.setOnClickListener {
            val intent = Intent(this, workoutArms::class.java)
            startActivity(intent)
        }
        workoutBodyButton.setOnClickListener {
            val intent = Intent(this, workoutBody::class.java)
            startActivity(intent)
        }
        workoutLegsButton.setOnClickListener {
            val intent = Intent(this, workoutLegs::class.java)
            startActivity(intent)
        }
        workoutAbsButton.setOnClickListener {
            val intent = Intent(this, workoutAbs::class.java)
            startActivity(intent)
        }
        workoutBackButton.setOnClickListener {
            val intent = Intent(this, workoutBack::class.java)
            startActivity(intent)
        }
        workoutShoulderButton.setOnClickListener {
            val intent = Intent(this, workoutShoulders::class.java)
            startActivity(intent)
        }
    }
}