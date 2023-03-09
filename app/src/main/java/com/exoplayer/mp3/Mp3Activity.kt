package com.exoplayer.mp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exoplayer.R
import com.google.android.exoplayer2.ExoPlayer

class Mp3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mp3)

        ExoPlayer.Builder(this)
    }
}