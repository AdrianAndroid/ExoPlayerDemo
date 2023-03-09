package com.exoplayer.wav

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.LinearLayoutCompat
import com.exoplayer.R
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.FileDataSource
import com.google.android.exoplayer2.upstream.RawResourceDataSource
import java.util.*

/**
 * https://exoplayer.dev/
 * https://cloud.tencent.com/developer/article/1809604
 */
class WavActivity : AppCompatActivity() {
    private var player: ExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wav)
        createButton("播放wav:file001") {
            playAssets(Uri.parse("file:///android_asset/file001.wav"))
        }
        createButton("播放R.raw.file002") {
            playRawWavFile()
        }
    }

    private fun createButton(title: String, onClick: ()->Unit) {
        val btn = Button(this)
        btn.text = title
        val container = findViewById<LinearLayoutCompat>(R.id.container)
        container.addView(btn)
        btn.setOnClickListener { onClick.invoke() }
    }

    // 读取本地文件
    private fun playAssets(uri: Uri) {
//        // 创建一个自定义的DataSource.Factory
//        val factory = DataSource.Factory { FileDataSource() }
//        // 将自定义的DataSource.Factory和Extractor注册到ExoPlayer中
//        val extractorsFactory: DefaultExtractorsFactory = DefaultExtractorsFactory()
//        val createExtractors = extractorsFactory.createExtractors(uri,
//            Collections.singletonMap("Content-Type", listOf("audio/wav")))
//        val player = ExoPlayer.Builder(this).build()
////        MediaSource.Factory
        val assetFile = "file:///android_asset/file001.wav"
        // Build the media item.
        val mediaItem = MediaItem.fromUri(assetFile)
        player = ExoPlayer.Builder(this).build()
        // Set the media item to be played
        player?.setMediaItem(mediaItem)
        // Prepare the player
        player?.prepare()
        // start the playback.
        player?.play()
    }

    // Android ExoPlayer播放raw文件夹下的文件
    // https://blog.csdn.net/greatyoulv/article/details/104071775
    private fun playRawWavFile() {
        val uri = RawResourceDataSource.buildRawResourceUri(R.raw.file002)
        val dataSourceFactory = DataSource.Factory { RawResourceDataSource(this) }
        val mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(MediaItem.fromUri(uri))
        player?.stop()
        player = ExoPlayer.Builder(this).build()
        player?.setMediaSource(mediaSource)
        player?.prepare()
        player?.play()
        player?.playWhenReady = true
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.stop()
        player?.release()
    }
}