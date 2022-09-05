package com.example.fitnessapp.android

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnessapp.android.databinding.ActivityChangeEmailBinding

class changeEmail : AppCompatActivity() {

    private lateinit var binding: ActivityChangeEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_email)

        binding = ActivityChangeEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        currentEmailFocusListener()
        newEmailFocusListener()
        passwordFocusListener()

        binding.appIcon.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.saveButton.setOnClickListener {
            if (TextUtils.isEmpty(binding.currentEmailEditText.text.toString())) {
                AlertDialog.Builder(this)
                    .setTitle("Current Email field cannot be empty!")
                    .setMessage("Please enter your current email")
                    .setPositiveButton("Okay"){_,_ ->
                    }
                    .show()
            }
            else if (TextUtils.isEmpty(binding.newEmailEditText.text.toString())) {
                AlertDialog.Builder(this)
                    .setTitle("New Email field cannot be empty!")
                    .setMessage("Please enter your new email")
                    .setPositiveButton("Okay"){_,_ ->
                    }
                    .show()
            }
            else if (TextUtils.isEmpty(binding.passwordEditText.text.toString())) {
                AlertDialog.Builder(this)
                    .setTitle("Password field cannot be empty!")
                    .setMessage("Please enter your password")
                    .setPositiveButton("Okay"){_,_ ->
                    }
                    .show()
            }
            else if (!Patterns.EMAIL_ADDRESS.matcher(binding.currentEmailEditText.text.toString()).matches() or !Patterns.EMAIL_ADDRESS.matcher(binding.newEmailEditText.text.toString()).matches()) {
                AlertDialog.Builder(this)
                    .setMessage("Please enter a valid email")
                    .setPositiveButton("Okay"){_,_ ->
                    }
                    .show()
            }
            else if (binding.passwordEditText.text.toString().length < 8) {
                AlertDialog.Builder(this)
                    .setTitle("Password is too short!")
                    .setMessage("Please enter a valid password")
                    .setPositiveButton("Okay"){_,_ ->
                    }
                    .show()
            }
            else {
                AlertDialog.Builder(this)
                    .setTitle("Successful!")
                    .setMessage("You successfully changed your email!")
                    .setPositiveButton("Okay"){_,_ ->
                        binding.currentEmailEditText.text = null
                        binding.newEmailEditText.text = null
                        binding.passwordEditText.text = null
                    }
                    .show()
            }
        }
    }

    // for current email
    private fun currentEmailFocusListener() {
        binding.currentEmailEditText.setOnFocusChangeListener { _, focused ->
            if (!focused){
                binding.currentEmailContainer.helperText = validEmail()
            }
        }
    }

    //for new email
    private fun newEmailFocusListener() {
        binding.newEmailEditText.setOnFocusChangeListener { _, focused ->
            if(!focused){
                binding.newEmailContainer.helperText = validNewEmail()
            }
        }
    }

    //return text that email is invalid
    private fun validEmail(): String? {

        val emailText = binding.currentEmailEditText.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches())
        {
            return "Invalid Email Address"
        }
        return null

    }

    private fun validNewEmail(): String? {

        val emailText = binding.newEmailEditText.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches())
        {
            return "Invalid Email Address"
        }
        return null

    }

    //for password
    private fun passwordFocusListener() {

        binding.passwordEditText.setOnFocusChangeListener { _, focused ->
            if(!focused){
                binding.passwordContainer.helperText = validPassword()
            }
        }
    }

    //return text that password is invalid
    private fun validPassword(): String? {

        val passwordText = binding.passwordEditText.text.toString()

        //password length
        if (passwordText.length < 8){

            return "Minimum of 8 Character Password"
        }

        //password 1 capital
        if (!passwordText.matches(".*[A-Z].*".toRegex())) {
            return "Must Contain 1 Upper-case Character"
        }

        //password 1 lower case
        if (!passwordText.matches(".*[a-z].*".toRegex())) {
            return "Must Contain 1 Lower-case Character"
        }

        //password 1 special character
        if (!passwordText.matches(".*[!@#$%^&*+_].*".toRegex())) {
            return "Must Contain 1 Special Character (!@#\$%^&*+_)"
        }

        return null

    }
}