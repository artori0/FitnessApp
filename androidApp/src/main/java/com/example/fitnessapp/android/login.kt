package com.example.fitnessapp.android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val register = findViewById<TextView>(R.id.tv_no_account)
        register.setOnClickListener{
            startActivity(Intent(this,com.example.fitnessapp.android.register::class.java))
        }

        val login = findViewById<Button>(R.id.btn_login)
        login.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

        val forgotPassword = findViewById<TextView>(R.id.tv_forgot_pw)
        forgotPassword.setOnClickListener {
            startActivity(Intent(this, resetPasswordLogin::class.java))
        }
    }
}