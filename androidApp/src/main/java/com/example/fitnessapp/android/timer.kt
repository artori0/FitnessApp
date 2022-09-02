package com.example.fitnessapp.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import java.util.*
import com.example.fitnessapp.android.databinding.ActivityTimerBinding

class timer : AppCompatActivity() {

    lateinit var binding: ActivityTimerBinding
    lateinit var dataHelper: dataHelper

    private val timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        binding = ActivityTimerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataHelper = dataHelper(applicationContext)

        binding.startButton.setOnClickListener{startStopAction()}
        binding.resetButton.setOnClickListener {resetAction()}

        val home = findViewById<ImageView>(R.id.appIcon)
        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        if(dataHelper.timerCounting())
        {
            startTimer()
        }
        else
        {
            stopTimer()
            if(dataHelper.startTime() != null && dataHelper.stopTime() != null)
            {
                val time = Date().time - calcRestartTime().time
                binding.timeTV.text = timeStringFromLong(time)

            }
        }

        timer.scheduleAtFixedRate(TimeTask(),0,500)

    }

    private inner class TimeTask: TimerTask()
    {
        override fun run() {
            if(dataHelper.timerCounting())
            {
                val time = Date().time - dataHelper.startTime()!!.time
                binding.timeTV.text = timeStringFromLong(time)
            }
        }
    }

    private fun resetAction() {
        dataHelper.setStopTime(null)
        dataHelper.setStartTime(null)
        stopTimer()
        binding.timeTV.text = timeStringFromLong(0)

    }


    private fun stopTimer() {
        dataHelper.setTimerCounting(false)
        binding.startButton.text = "Start"
    }

    private fun startTimer() {
        dataHelper.setTimerCounting(true)
        binding.startButton.text = "Stop"
    }


    private fun startStopAction() {
        if(dataHelper.timerCounting())
        {
            dataHelper.setStopTime(Date())
            stopTimer()

        }

        else
        {
            if(dataHelper.stopTime() != null)
            {
                dataHelper.setStartTime(calcRestartTime())
                dataHelper.setStopTime(null)
            }
            else
            {
                dataHelper.setStartTime(Date())

            }
            startTimer()

        }
    }

    private fun calcRestartTime(): Date {
        val diff = dataHelper.startTime()!!.time - dataHelper.stopTime()!!.time
        return Date(System.currentTimeMillis() + diff)


    }

    private fun timeStringFromLong(ms: Long): String {

        val seconds = (ms / 1000) % 60
        val minutes = (ms / 1000 * 60) % 60
        val hours = (ms / (1000 * 60 * 60)% 24)
        return makeTimeString(hours,minutes,seconds)

    }

    private fun makeTimeString(hours: Long, minutes: Long, seconds: Long): String {
        return String.format("%02d:%02d:%02d" , hours, minutes, seconds)
    }
}