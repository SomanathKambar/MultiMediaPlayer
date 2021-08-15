package com.somanath.multimediaplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.DefaultLoadControl
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.util.Util

class MainActivity : AppCompatActivity() {
    lateinit var videoPlayer: SimpleExoPlayer
    lateinit var audioPlayer: SimpleExoPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createVideoPlayer()
    }

    fun createVideoPlayer() {
        val trackSelector = DefaultTrackSelector()
        val loadControl = DefaultLoadControl()
        videoPlayer = SimpleExoPlayer.Builder(this)
            .setTrackSelector(trackSelector)
            .setLoadControl(loadControl)
            .build()
        videoPlayer.videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING

        val mediaItem = MediaItem.fromUri(getString(R.string.media_url_mp3))
        videoPlayer.setMediaItem(mediaItem)
        findViewById<PlayerView>(R.id.playerView).player = videoPlayer
    }

    fun createAudioPlayer() {

    }

    fun createMediaSource() {
        val userAgent = Util.getUserAgent(this, getString(R.string.app_name))

    }
}