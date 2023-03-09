package com.exoplayerlib.wav

import android.content.Context
import android.net.Uri
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.ProgressiveMediaSource

class WavExoPlayer {

    fun test(context: Context) {
        val player = ExoPlayer.Builder(context).build()
        val firstItem = MediaItem.fromUri(Uri.parse(""))
        val secondItem = MediaItem.fromUri((Uri.parse("")))
        player.addMediaItem(firstItem)
        player.addMediaItem(secondItem)
        player.prepare()
        player.play()
    }

}