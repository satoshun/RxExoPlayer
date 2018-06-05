package com.github.satoshun.reactivex.exoplayer2.hls

import com.google.android.exoplayer2.Format
import com.google.android.exoplayer2.upstream.DataSpec
import java.io.IOException

sealed class MediaSourceEvent

class LoadStartedEvent(
    val dataSpec: DataSpec?,
    val dataType: Int,
    val trackType: Int,
    val trackFormat: Format?,
    val trackSelectionReason: Int,
    val trackSelectionData: Any?,
    val mediaStartTimeMs: Long,
    val mediaEndTimeMs: Long,
    val elapsedRealtimeMs: Long
) : MediaSourceEvent()

class DownstreamFormatChangedEvent(
    val trackType: Int,
    val trackFormat: Format?,
    val trackSelectionReason: Int,
    val trackSelectionData: Any?,
    val mediaTimeMs: Long
) : MediaSourceEvent()

class UpstreamDiscardedEvent(
    val trackType: Int,
    val mediaStartTimeMs: Long,
    val mediaEndTimeMs: Long
) : MediaSourceEvent()

class LoadCompletedEvent(
    val dataSpec: DataSpec?,
    val dataType: Int,
    val trackType: Int,
    val trackFormat: Format?,
    val trackSelectionReason: Int,
    val trackSelectionData: Any?,
    val mediaStartTimeMs: Long,
    val mediaEndTimeMs: Long,
    val elapsedRealtimeMs: Long,
    val loadDurationMs: Long,
    val bytesLoaded: Long
) : MediaSourceEvent()

class LoadCanceledEvent(
    val dataSpec: DataSpec?,
    val dataType: Int,
    val trackType: Int,
    val trackFormat: Format?,
    val trackSelectionReason: Int,
    val trackSelectionData: Any?,
    val mediaStartTimeMs: Long,
    val mediaEndTimeMs: Long,
    val elapsedRealtimeMs: Long,
    val loadDurationMs: Long,
    val bytesLoaded: Long
) : MediaSourceEvent()

class LoadErrorEvent(
    val dataSpec: DataSpec?,
    val dataType: Int,
    val trackType: Int,
    val trackFormat: Format?,
    val trackSelectionReason: Int,
    val trackSelectionData: Any?,
    val mediaStartTimeMs: Long,
    val mediaEndTimeMs: Long,
    val elapsedRealtimeMs: Long,
    val loadDurationMs: Long,
    val bytesLoaded: Long,
    val error: IOException?,
    val wasCanceled: Boolean
) : MediaSourceEvent()
