package com.github.satoshun.reactivex.exoplayer2.hls

import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.MediaSourceEventListener
import java.io.IOException

sealed class MediaSourceEvent

class LoadStartedEvent(
    val windowIndex: Int,
    val mediaPeriodId: MediaSource.MediaPeriodId?,
    val loadEventInfo: MediaSourceEventListener.LoadEventInfo?,
    val mediaLoadData: MediaSourceEventListener.MediaLoadData?
) : MediaSourceEvent()

class DownstreamFormatChangedEvent(
    val windowIndex: Int,
    val mediaPeriodId: MediaSource.MediaPeriodId?,
    val mediaLoadData: MediaSourceEventListener.MediaLoadData?
) : MediaSourceEvent()

class UpstreamDiscardedEvent(
    val windowIndex: Int,
    val mediaPeriodId: MediaSource.MediaPeriodId?,
    val mediaLoadData: MediaSourceEventListener.MediaLoadData?
) : MediaSourceEvent()

class LoadCompletedEvent(
    val windowIndex: Int,
    val mediaPeriodId: MediaSource.MediaPeriodId?,
    val loadEventInfo: MediaSourceEventListener.LoadEventInfo?,
    val mediaLoadData: MediaSourceEventListener.MediaLoadData?
) : MediaSourceEvent()

class LoadCanceledEvent(
    val windowIndex: Int,
    val mediaPeriodId: MediaSource.MediaPeriodId?,
    val loadEventInfo: MediaSourceEventListener.LoadEventInfo?,
    val mediaLoadData: MediaSourceEventListener.MediaLoadData?
) : MediaSourceEvent()

class LoadErrorEvent(
    val windowIndex: Int,
    val mediaPeriodId: MediaSource.MediaPeriodId?,
    val loadEventInfo: MediaSourceEventListener.LoadEventInfo?,
    val mediaLoadData: MediaSourceEventListener.MediaLoadData?,
    val error: IOException?,
    val wasCanceled: Boolean
) : MediaSourceEvent()

class MediaPeriodCreatedEvent(
    val windowIndex: Int,
    val mediaPeriodId: MediaSource.MediaPeriodId?
) : MediaSourceEvent()

class MediaPeriodReleasedEvent(
    val windowIndex: Int,
    val mediaPeriodId: MediaSource.MediaPeriodId?
) : MediaSourceEvent()

class ReadingStartedEvent(
    val windowIndex: Int,
    val mediaPeriodId: MediaSource.MediaPeriodId?
) : MediaSourceEvent()
