package com.github.satoshun.reactivex.exoplayer2.hls

import android.net.Uri
import android.os.Looper
import androidx.test.InstrumentationRegistry
import androidx.test.annotation.UiThreadTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.github.satoshun.reactivex.exoplayer2.TestActivity
import com.google.android.exoplayer2.DefaultLoadControl
import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

private const val HLS_SAMPLE = "https://devstreaming-cdn.apple.com/videos/streaming/examples/img_bipbop_adv_example_ts/master.m3u8"

@RunWith(AndroidJUnit4::class)
class RxMediaSourceEventTest {

  @Rule @JvmField val activityTestRule = ActivityTestRule(TestActivity::class.java)

  private lateinit var exoPlayer: ExoPlayer
  private lateinit var mediaSource: MediaSource

  @Before @UiThreadTest
  fun setUp() {
    exoPlayer = ExoPlayerFactory.newSimpleInstance(
        DefaultRenderersFactory(activityTestRule.activity),
        DefaultTrackSelector(AdaptiveTrackSelection.Factory(DefaultBandwidthMeter())),
        DefaultLoadControl()
    )
    exoPlayer.playWhenReady = true

//    val classLoader = javaClass.classLoader
//    val resource = classLoader.getResource("big_buck_bunny.mp4")
//    val file = File(resource.path)
//    val fileDataSource = FileDataSource()
//    fileDataSource.open(DataSpec(Uri.fromFile(file)))

    val mediaDataSourceFactory = DefaultDataSourceFactory(activityTestRule.activity, "test")
    mediaSource = HlsMediaSource
        .Factory(mediaDataSourceFactory)
        .createMediaSource(Uri.parse(HLS_SAMPLE))

//    playerView = PlayerView(activityTestRule.activity)
  }

  @Test
  fun LoadCompletedEvent_is_called_at_first() {
    Looper.prepare()
    var events: TestObserver<MediaSourceEvent>? = null
    InstrumentationRegistry.getInstrumentation().runOnMainSync {
      events = mediaSource.events().test()
      exoPlayer.prepare(mediaSource)
    }

    val test = events!!

    test.awaitCount(1)
        .assertValueAt(0) {
          it is LoadCompletedEvent
        }
  }
}
