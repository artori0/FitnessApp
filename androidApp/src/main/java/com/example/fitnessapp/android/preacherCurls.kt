package com.example.fitnessapp.android

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView

class preacherCurls : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preacher_curls)

        val bicepCurlReps = findViewById<TextView>(R.id.WorkoutReps)
        bicepCurlReps.text = getString(R.string._4_sets_12_reps) +
                " " +
                getString(R.string.workout_pause)

        val video = findViewById<VideoView>(R.id.Video)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(video)
        val uri: Uri =
            Uri.parse("android.resource://com.example.fitnessapp.android/" + R.raw.ezbarcurl)
        video.setMediaController(mediaController)
        video.setVideoURI(uri)

        video.setOnClickListener {
            video.requestFocus()
            video.start()
        }
    }
}