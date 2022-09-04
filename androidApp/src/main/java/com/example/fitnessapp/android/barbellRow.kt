package com.example.fitnessapp.android

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class barbellRow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barbell_row)

        val video = findViewById<VideoView>(R.id.Video)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(video)
        val uri: Uri =
            Uri.parse("android.resource://com.example.fitnessapp.android/" + R.raw.barbellrow)
        video.setMediaController(mediaController)
        video.setVideoURI(uri)

        video.setOnClickListener {
            video.requestFocus()
            video.start()
        }
    }
}