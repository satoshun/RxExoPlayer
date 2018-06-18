package com.github.satoshun.reactivex.exoplayer2.source

import android.net.Uri
import android.os.Looper
import androidx.test.InstrumentationRegistry
import androidx.test.annotation.UiThreadTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.github.satoshun.reactivex.exoplayer2.TestActivity
import com.github.satoshun.reactivex.exoplayer2.containsIsInstanceOf
import com.github.satoshun.reactivex.exoplayer2.doesNotContainIsInstanceOf
import com.github.satoshun.reactivex.exoplayer2.isInstanceOf
import com.google.android.exoplayer2.DefaultLoadControl
import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import io.reactivex.observers.TestObserver
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

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

    mediaSource = ExtractorMediaSource
        .Factory(DefaultDataSourceFactory(activityTestRule.activity, "test"))
        .setExtractorsFactory(DefaultExtractorsFactory())
        .createMediaSource(Uri.parse("asset:///big_buck_bunny.mp4"))
  }

  @After
  fun tearDown() {
    exoPlayer.release()
  }

  @Test
  fun MediaPeriodCreatedEvent_is_called_at_first_when_loading_from_asset() {
    tryPrepareLooper()
    var events: TestObserver<MediaSourceEvent>? = null
    InstrumentationRegistry.getInstrumentation().runOnMainSync {
      events = mediaSource.events().test()
      exoPlayer.prepare(mediaSource)
    }

    val test = events!!

    test.awaitCount(1)
        .values()[0].isInstanceOf<MediaPeriodCreatedEvent>()
  }

  @Test
  fun LoadStartedEvent_include_events_stream() {
    tryPrepareLooper()
    var events: TestObserver<MediaSourceEvent>? = null
    InstrumentationRegistry.getInstrumentation().runOnMainSync {
      events = mediaSource.events().test()
      exoPlayer.prepare(mediaSource)
    }

    val test = events!!

    test.awaitCount(1)
        .values().containsIsInstanceOf<LoadStartedEvent>()
  }

  @Test
  fun LoadErrorEvent_not_include_events_stream() {
    tryPrepareLooper()
    var events: TestObserver<MediaSourceEvent>? = null
    InstrumentationRegistry.getInstrumentation().runOnMainSync {
      events = mediaSource.events().test()
      exoPlayer.prepare(mediaSource)
    }

    val test = events!!

    test.awaitCount(1)
        .values().doesNotContainIsInstanceOf<LoadErrorEvent>()
  }
}


private fun tryPrepareLooper() {
  try {
    Looper.prepare()
  } catch (e: Exception) {
  }
}
