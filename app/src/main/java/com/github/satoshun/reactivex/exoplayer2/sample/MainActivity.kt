package com.github.satoshun.reactivex.exoplayer2.sample

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.github.satoshun.reactivex.exoplayer2.events
import com.github.satoshun.reactivex.exoplayer2.source.events
import com.google.android.exoplayer2.DefaultLoadControl
import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import io.reactivex.disposables.CompositeDisposable

private const val HLS_SAMPLE = "https://devstreaming-cdn.apple.com/videos/streaming/examples/img_bipbop_adv_example_ts/master.m3u8"

class MainActivity : AppCompatActivity() {
  private val disposables = CompositeDisposable()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_act)

    val playerView = findViewById<PlayerView>(R.id.player)
    val player = ExoPlayerFactory.newSimpleInstance(
        DefaultRenderersFactory(this),
        DefaultTrackSelector(AdaptiveTrackSelection.Factory(DefaultBandwidthMeter())),
        DefaultLoadControl()
    )
    player.playWhenReady = true
    playerView.player = player

    val mediaDataSourceFactory = DefaultDataSourceFactory(this, "test")
    val source = HlsMediaSource
        .Factory(mediaDataSourceFactory)
        .createMediaSource(Uri.parse(HLS_SAMPLE))
    disposables.add(
        source.events()
            .subscribe {
              Log.d("MediaSourceEvent", it.toString())
            }
    )
    disposables.add(
        player.events()
            .subscribe {
              Log.d("Player.EventListener", it.toString())
            }
    )

    player.prepare(source)
  }

  override fun onDestroy() {
    disposables.clear()
    super.onDestroy()
  }
}
