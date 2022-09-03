package com.example.fitnessapp.android

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class mainpage : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainpage)

        val register = findViewById<Button>(R.id.btn_register)
        register.setOnClickListener{
            startActivity(Intent(this,com.example.fitnessapp.android.register::class.java))
        }

        val login = findViewById<Button>(R.id.btn_login)
        login.setOnClickListener{
            startActivity(Intent(this,com.example.fitnessapp.android.login::class.java))
        }
    }
}