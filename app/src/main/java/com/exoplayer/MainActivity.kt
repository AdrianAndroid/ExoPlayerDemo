package com.exoplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.exoplayer.mp3.Mp3Activity
import com.exoplayer.wav.WavActivity

/**
 * https://exoplayer.dev/
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.btnWav).setOnClickListener {
            startActivity(Intent(this@MainActivity, WavActivity::class.java))
        }
        findViewById<View>(R.id.btnMp3).setOnClickListener {
            startActivity(Intent(this@MainActivity, Mp3Activity::class.java))
        }
    }
}