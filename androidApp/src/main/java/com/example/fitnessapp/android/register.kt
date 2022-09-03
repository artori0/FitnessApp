package com.example.fitnessapp.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val register = findViewById<Button>(R.id.btn_register)
        register.setOnClickListener{
            startActivity(Intent(this,login::class.java))
        }

        val hasAccount = findViewById<TextView>(R.id.tv_have_account)
        hasAccount.setOnClickListener{
            startActivity(Intent(this,login::class.java))
        }
    }
}