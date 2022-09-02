package com.example.fitnessapp.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AlertDialog
import com.example.fitnessapp.android.databinding.ActivityChangePasswordBinding

class changePassword : AppCompatActivity() {

    private lateinit var binding: ActivityChangePasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        emailFocusListener()
        newPasswordFocusListener()

        binding.appIcon.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.saveButton.setOnClickListener {
            val newPasswordText = binding.newPasswordEditText.text.toString()
            if (!Patterns.EMAIL_ADDRESS.matcher(binding.emailEditText.text.toString()).matches()) {
                AlertDialog.Builder(this)
                    .setMessage("Please enter a valid email")
                    .setPositiveButton("Okay"){_,_ ->
                        //do nothing
                    }
                    .show()
            }
            else if (newPasswordText.length < 8 ) {
                AlertDialog.Builder(this)
                    .setMessage("Please enter a valid password")
                    .setPositiveButton("Okay"){_,_ ->
                        //do nothing
                    }
                    .show()
            }
            else if (!newPasswordText.matches(".*[A-Z].*".toRegex())
                or !newPasswordText.matches(".*[a-z].*".toRegex())
                or !newPasswordText.matches(".*[!@#$%^&*+_].*".toRegex())) {
                AlertDialog.Builder(this)
                    .setMessage("Please enter a valid password")
                    .setPositiveButton("Okay"){_,_ ->
                        //do nothing
                    }
                    .show()
            }
            else {
                submitForm()
            }
        }
    }
    private fun submitForm() {
        val newPassword = binding.newPasswordEditText.text.toString()
        val confirmPassword = binding.confirmPasswordEditText.text.toString()

        if(newPassword == confirmPassword){

            resetForm()
        }

        else
            invalidForm()
    }

    private fun invalidForm() {

        var message = ""

        if(binding.newPasswordEditText.text != binding.confirmPasswordEditText.text)
            message  = "Your passwords do not match!"

        AlertDialog.Builder(this)
            .setTitle("Invalid!")
            .setMessage(message)
            .setPositiveButton("okay"){_,_ ->
                //do nothing
            }
            .show()
    }

    private fun resetForm() {

        AlertDialog.Builder(this)
            .setTitle("Successful!")
            .setMessage("You successfully changed your password!")
            .setPositiveButton("Okay"){_,_ ->

                binding.newPasswordEditText.text = null
                binding.confirmPasswordEditText.text = null
                binding.emailEditText.text = null
            }
            .show()
    }


    private fun emailFocusListener() {
        binding.emailEditText.setOnFocusChangeListener { _, focused ->
            if (!focused){
                binding.emailContainer.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String? {

        val emailText = binding.emailEditText.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches())
        {
            return "Invalid Email Address"
        }
        return null

    }

    //for passwords
    private fun newPasswordFocusListener() {

        binding.newPasswordEditText.setOnFocusChangeListener { _, focused ->
            if(!focused){
                binding.newPasswordContainer.helperText = newPassword()
            }
        }
    }

    //return text that password is invalid
    private fun newPassword(): String? {

        val newPasswordText = binding.newPasswordEditText.text.toString()

        //password length
        if (newPasswordText.length < 8){

            return "Minimum of 8 Character Password"
        }

        //password 1 capital
        if (!newPasswordText.matches(".*[A-Z].*".toRegex())) {
            return "Must Contain 1 Upper-case Character"
        }

        //password 1 lower case
        if (!newPasswordText.matches(".*[a-z].*".toRegex())) {
            return "Must Contain 1 Lower-case Character"
        }

        //password 1 special character
        if (!newPasswordText.matches(".*[!@#$%^&*+_].*".toRegex())) {
            return "Must Contain 1 Special Character (!@#\$%^&*+_)"
        }

        return null

    }
}