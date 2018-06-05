package com.github.satoshun.reactivex.exoplayer2.hls.internal

import com.github.satoshun.reactivex.exoplayer2.hls.DownstreamFormatChangedEvent
import com.github.satoshun.reactivex.exoplayer2.hls.LoadCanceledEvent
import com.github.satoshun.reactivex.exoplayer2.hls.LoadCompletedEvent
import com.github.satoshun.reactivex.exoplayer2.hls.LoadErrorEvent
import com.github.satoshun.reactivex.exoplayer2.hls.LoadStartedEvent
import com.github.satoshun.reactivex.exoplayer2.hls.MediaSourceEvent
import com.github.satoshun.reactivex.exoplayer2.hls.UpstreamDiscardedEvent
import com.google.android.exoplayer2.Format
import com.google.android.exoplayer2.source.MediaSourceEventListener
import com.google.android.exoplayer2.upstream.DataSpec
import io.reactivex.Observer
import java.io.IOException

internal class MediaSourceEventObservable(
    private val subject: Observer<MediaSourceEvent>
) : MediaSourceEventListener {
  override fun onLoadStarted(
      dataSpec: DataSpec?,
      dataType: Int,
      trackType: Int,
      trackFormat: Format?,
      trackSelectionReason: Int,
      trackSelectionData: Any?,
      mediaStartTimeMs: Long,
      mediaEndTimeMs: Long,
      elapsedRealtimeMs: Long
  ) {
    subject.onNext(LoadStartedEvent(
        dataSpec,
        dataType,
        trackType,
        trackFormat,
        trackSelectionReason,
        trackSelectionData,
        mediaStartTimeMs,
        mediaEndTimeMs,
        elapsedRealtimeMs
    ))
  }

  override fun onDownstreamFormatChanged(
      trackType: Int, trackFormat: Format?,
      trackSelectionReason: Int, trackSelectionData: Any?,
      mediaTimeMs: Long
  ) {
    subject.onNext(DownstreamFormatChangedEvent(
        trackType,
        trackFormat,
        trackSelectionReason,
        trackSelectionData,
        mediaTimeMs
    ))
  }

  override fun onUpstreamDiscarded(trackType: Int, mediaStartTimeMs: Long, mediaEndTimeMs: Long) {
    subject.onNext(UpstreamDiscardedEvent(
        trackType,
        mediaStartTimeMs,
        mediaEndTimeMs
    ))
  }

  override fun onLoadCompleted(
      dataSpec: DataSpec?, dataType: Int, trackType: Int,
      trackFormat: Format?, trackSelectionReason: Int,
      trackSelectionData: Any?, mediaStartTimeMs: Long,
      mediaEndTimeMs: Long, elapsedRealtimeMs: Long, loadDurationMs: Long,
      bytesLoaded: Long
  ) {
    subject.onNext(LoadCompletedEvent(
        dataSpec,
        dataType,
        trackType,
        trackFormat,
        trackSelectionReason,
        trackSelectionData,
        mediaStartTimeMs,
        mediaEndTimeMs,
        elapsedRealtimeMs,
        loadDurationMs,
        bytesLoaded
    ))
  }

  override fun onLoadCanceled(
      dataSpec: DataSpec?, dataType: Int, trackType: Int,
      trackFormat: Format?, trackSelectionReason: Int,
      trackSelectionData: Any?, mediaStartTimeMs: Long,
      mediaEndTimeMs: Long, elapsedRealtimeMs: Long, loadDurationMs: Long,
      bytesLoaded: Long
  ) {
    subject.onNext(LoadCanceledEvent(
        dataSpec,
        dataType,
        trackType,
        trackFormat,
        trackSelectionReason,
        trackSelectionData,
        mediaStartTimeMs,
        mediaEndTimeMs,
        elapsedRealtimeMs,
        loadDurationMs,
        bytesLoaded
    ))
  }

  override fun onLoadError(
      dataSpec: DataSpec?, dataType: Int, trackType: Int, trackFormat: Format?,
      trackSelectionReason: Int, trackSelectionData: Any?,
      mediaStartTimeMs: Long, mediaEndTimeMs: Long, elapsedRealtimeMs: Long,
      loadDurationMs: Long, bytesLoaded: Long, error: IOException?,
      wasCanceled: Boolean
  ) {
    subject.onNext(LoadErrorEvent(
        dataSpec,
        dataType,
        trackType,
        trackFormat,
        trackSelectionReason,
        trackSelectionData,
        mediaStartTimeMs,
        mediaEndTimeMs,
        elapsedRealtimeMs,
        loadDurationMs,
        bytesLoaded,
        error,
        wasCanceled
    ))
  }
}
