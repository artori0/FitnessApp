package com.example.fitnessapp.android

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView

class dumbbellPress : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dumbbell_press)

        val video = findViewById<VideoView>(R.id.Video)

        val dumbbellPressReps = findViewById<TextView>(R.id.WorkoutReps)
        dumbbellPressReps.text = getString(R.string._3_sets_8_reps) +
                " " +
                getString(R.string.double_dropset)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(video)
        val uri: Uri =
            Uri.parse("android.resource://com.example.fitnessapp.android/" + R.raw.dumbbellpress)
        video.setMediaController(mediaController)
        video.setVideoURI(uri)

        video.setOnClickListener {
            video.requestFocus()
            video.start()
        }
    }
}