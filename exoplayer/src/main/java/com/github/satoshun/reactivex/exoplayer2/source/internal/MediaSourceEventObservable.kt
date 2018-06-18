package com.github.satoshun.reactivex.exoplayer2.source.internal

import android.os.Handler
import com.github.satoshun.reactivex.exoplayer2.source.DownstreamFormatChangedEvent
import com.github.satoshun.reactivex.exoplayer2.source.LoadCanceledEvent
import com.github.satoshun.reactivex.exoplayer2.source.LoadCompletedEvent
import com.github.satoshun.reactivex.exoplayer2.source.LoadErrorEvent
import com.github.satoshun.reactivex.exoplayer2.source.LoadStartedEvent
import com.github.satoshun.reactivex.exoplayer2.source.MediaPeriodCreatedEvent
import com.github.satoshun.reactivex.exoplayer2.source.MediaPeriodReleasedEvent
import com.github.satoshun.reactivex.exoplayer2.source.MediaSourceEvent
import com.github.satoshun.reactivex.exoplayer2.source.ReadingStartedEvent
import com.github.satoshun.reactivex.exoplayer2.source.UpstreamDiscardedEvent
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.MediaSourceEventListener
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.MainThreadDisposable
import java.io.IOException

internal class MediaSourceEventObservable(
    private val mediaSource: MediaSource,
    private val handler: Handler
) : Observable<MediaSourceEvent>() {
  override fun subscribeActual(observer: Observer<in MediaSourceEvent>) {
    val listener = Listener(observer, mediaSource)
    observer.onSubscribe(listener)
    mediaSource.addEventListener(handler, listener)
  }

  private class Listener(
      private val observer: Observer<in MediaSourceEvent>,
      private val mediaSource: MediaSource
  ) : MainThreadDisposable(),
      MediaSourceEventListener {
    override fun onLoadStarted(
        windowIndex: Int,
        mediaPeriodId: MediaSource.MediaPeriodId?,
        loadEventInfo: MediaSourceEventListener.LoadEventInfo?,
        mediaLoadData: MediaSourceEventListener.MediaLoadData?
    ) {
      if (isDisposed) return
      observer.onNext(LoadStartedEvent(
          windowIndex,
          mediaPeriodId,
          loadEventInfo,
          mediaLoadData
      ))
    }

    override fun onDownstreamFormatChanged(
        windowIndex: Int,
        mediaPeriodId: MediaSource.MediaPeriodId?,
        mediaLoadData: MediaSourceEventListener.MediaLoadData?
    ) {
      if (isDisposed) return
      observer.onNext(DownstreamFormatChangedEvent(
          windowIndex,
          mediaPeriodId,
          mediaLoadData
      ))
    }

    override fun onUpstreamDiscarded(
        windowIndex: Int,
        mediaPeriodId: MediaSource.MediaPeriodId?,
        mediaLoadData: MediaSourceEventListener.MediaLoadData?
    ) {
      if (isDisposed) return
      observer.onNext(UpstreamDiscardedEvent(
          windowIndex,
          mediaPeriodId,
          mediaLoadData
      ))
    }

    override fun onLoadCompleted(
        windowIndex: Int,
        mediaPeriodId: MediaSource.MediaPeriodId?,
        loadEventInfo: MediaSourceEventListener.LoadEventInfo?,
        mediaLoadData: MediaSourceEventListener.MediaLoadData?
    ) {
      if (isDisposed) return
      observer.onNext(LoadCompletedEvent(
          windowIndex,
          mediaPeriodId,
          loadEventInfo,
          mediaLoadData
      ))
    }

    override fun onLoadCanceled(
        windowIndex: Int,
        mediaPeriodId: MediaSource.MediaPeriodId?,
        loadEventInfo: MediaSourceEventListener.LoadEventInfo?,
        mediaLoadData: MediaSourceEventListener.MediaLoadData?
    ) {
      if (isDisposed) return
      observer.onNext(LoadCanceledEvent(
          windowIndex,
          mediaPeriodId,
          loadEventInfo,
          mediaLoadData
      ))
    }

    override fun onLoadError(
        windowIndex: Int,
        mediaPeriodId: MediaSource.MediaPeriodId?,
        loadEventInfo: MediaSourceEventListener.LoadEventInfo?,
        mediaLoadData: MediaSourceEventListener.MediaLoadData?,
        error: IOException?,
        wasCanceled: Boolean
    ) {
      if (isDisposed) return
      observer.onNext(LoadErrorEvent(
          windowIndex,
          mediaPeriodId,
          loadEventInfo,
          mediaLoadData,
          error,
          wasCanceled
      ))
    }

    override fun onMediaPeriodCreated(windowIndex: Int, mediaPeriodId: MediaSource.MediaPeriodId?) {
      if (isDisposed) return
      observer.onNext(MediaPeriodCreatedEvent(
          windowIndex,
          mediaPeriodId
      ))
    }

    override fun onMediaPeriodReleased(
        windowIndex: Int,
        mediaPeriodId: MediaSource.MediaPeriodId?
    ) {
      if (isDisposed) return
      observer.onNext(MediaPeriodReleasedEvent(
          windowIndex,
          mediaPeriodId
      ))
    }

    override fun onReadingStarted(windowIndex: Int, mediaPeriodId: MediaSource.MediaPeriodId?) {
      if (isDisposed) return
      observer.onNext(ReadingStartedEvent(
          windowIndex,
          mediaPeriodId
      ))
    }

    override fun onDispose() {
      mediaSource.removeEventListener(this)
    }
  }
}
