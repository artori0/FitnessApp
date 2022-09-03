package com.example.fitnessapp.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

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
    }
}