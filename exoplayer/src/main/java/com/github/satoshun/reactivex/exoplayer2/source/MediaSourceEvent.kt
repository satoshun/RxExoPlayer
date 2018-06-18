package com.github.satoshun.reactivex.exoplayer2.source

import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.MediaSourceEventListener
import java.io.IOException

/**
 * A event on MediaSource
 */
sealed class MediaSourceEvent

/**
 * A event on MediaSource.onLoadStarted
 */
class LoadStartedEvent(
    val windowIndex: Int,
    val mediaPeriodId: MediaSource.MediaPeriodId?,
    val loadEventInfo: MediaSourceEventListener.LoadEventInfo?,
    val mediaLoadData: MediaSourceEventListener.MediaLoadData?
) : MediaSourceEvent()

/**
 * A event on MediaSource.onDownstreamFormatChanged
 */
class DownstreamFormatChangedEvent(
    val windowIndex: Int,
    val mediaPeriodId: MediaSource.MediaPeriodId?,
    val mediaLoadData: MediaSourceEventListener.MediaLoadData?
) : MediaSourceEvent()

/**
 * A event on MediaSource.onUpstreamDiscarded
 */
class UpstreamDiscardedEvent(
    val windowIndex: Int,
    val mediaPeriodId: MediaSource.MediaPeriodId?,
    val mediaLoadData: MediaSourceEventListener.MediaLoadData?
) : MediaSourceEvent()

/**
 * A event on MediaSource.onLoadCompleted
 */
class LoadCompletedEvent(
    val windowIndex: Int,
    val mediaPeriodId: MediaSource.MediaPeriodId?,
    val loadEventInfo: MediaSourceEventListener.LoadEventInfo?,
    val mediaLoadData: MediaSourceEventListener.MediaLoadData?
) : MediaSourceEvent()

/**
 * A event on MediaSource.onLoadCanceled
 */
class LoadCanceledEvent(
    val windowIndex: Int,
    val mediaPeriodId: MediaSource.MediaPeriodId?,
    val loadEventInfo: MediaSourceEventListener.LoadEventInfo?,
    val mediaLoadData: MediaSourceEventListener.MediaLoadData?
) : MediaSourceEvent()

/**
 * A event on MediaSource.onLoadError
 */
class LoadErrorEvent(
    val windowIndex: Int,
    val mediaPeriodId: MediaSource.MediaPeriodId?,
    val loadEventInfo: MediaSourceEventListener.LoadEventInfo?,
    val mediaLoadData: MediaSourceEventListener.MediaLoadData?,
    val error: IOException?,
    val wasCanceled: Boolean
) : MediaSourceEvent()

/**
 * A event on MediaSource.onMediaPeriodCreated
 */
class MediaPeriodCreatedEvent(
    val windowIndex: Int,
    val mediaPeriodId: MediaSource.MediaPeriodId?
) : MediaSourceEvent()

/**
 * A event on MediaSource.onMediaPeriodReleased
 */
class MediaPeriodReleasedEvent(
    val windowIndex: Int,
    val mediaPeriodId: MediaSource.MediaPeriodId?
) : MediaSourceEvent()

/**
 * A event on MediaSource.onReadingStarted
 */
class ReadingStartedEvent(
    val windowIndex: Int,
    val mediaPeriodId: MediaSource.MediaPeriodId?
) : MediaSourceEvent()
