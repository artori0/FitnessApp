package com.example.fitnessapp.android

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnessapp.android.databinding.ActivityFeedbackBinding

class feedback : AppCompatActivity() {

    private lateinit var binding: ActivityFeedbackBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        binding = ActivityFeedbackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.appIcon.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.submitButton.setOnClickListener {
            if (TextUtils.isEmpty(binding.feedbackEditText.text.toString())) {
                AlertDialog.Builder(this)
                    .setTitle("Feedback form is empty!")
                    .setMessage("Please enter text in the feedback form")
                    .setPositiveButton("Okay"){_,_ ->
                    }
                    .show()
            }
            else{
                submitForm()
            }
        }
    }

    private fun submitForm() {

        AlertDialog.Builder(this)
            .setTitle("Submitted!")
            .setMessage("Thank you for your feedback!")
            .setPositiveButton("Okay"){_,_ ->

                finish()

            }
            .show()
    }
}