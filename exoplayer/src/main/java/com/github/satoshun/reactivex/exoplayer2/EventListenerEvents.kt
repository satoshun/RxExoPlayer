package com.github.satoshun.reactivex.exoplayer2

import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.PlaybackParameters
import com.google.android.exoplayer2.Timeline
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.trackselection.TrackSelectionArray

sealed class PlayerEvent

class PlaybackParametersChangedEvent(
    val playbackParameters: PlaybackParameters
) : PlayerEvent()

object SeekProcessedEvent : PlayerEvent()

class TracksChangedEvent(
    val trackGroups: TrackGroupArray,
    val trackSelections: TrackSelectionArray
) : PlayerEvent()

class PlayerErrorEvent(
    val error: ExoPlaybackException
) : PlayerEvent()

class LoadingChangedEvent(
    val isLoading: Boolean
) : PlayerEvent()

class PositionDiscontinuityEvent(
    val reason: Int
) : PlayerEvent()

class RepeatModeChangedEvent(
    val repeatMode: Int
) : PlayerEvent()

class ShuffleModeEnabledChangedEvent(
    val shuffleModeEnabled: Boolean
) : PlayerEvent()

class TimelineChangedEvent(
    val timeline: Timeline?,
    val manifest: Any?,
    val reason: Int
) : PlayerEvent()

class PlayerStateChangedEvent(
    val playWhenReady: Boolean,
    val playbackState: Int
) : PlayerEvent()
