package com.github.satoshun.reactivex.exoplayer2

import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.PlaybackParameters
import com.google.android.exoplayer2.Timeline
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.trackselection.TrackSelectionArray

sealed class RxExoPlayerEvent

class PlaybackParametersChangedEvent(
    val playbackParameters: PlaybackParameters
) : RxExoPlayerEvent()

object SeekProcessedEvent : RxExoPlayerEvent()

class TracksChangedEvent(
    val trackGroups: TrackGroupArray,
    val trackSelections: TrackSelectionArray
) : RxExoPlayerEvent()

class PlayerErrorEvent(
    val error: ExoPlaybackException
) : RxExoPlayerEvent()

class LoadingChangedEvent(
    val isLoading: Boolean
) : RxExoPlayerEvent()

class PositionDiscontinuityEvent(
    val reason: Int
) : RxExoPlayerEvent()

class RepeatModeChangedEvent(
    val repeatMode: Int
) : RxExoPlayerEvent()

class ShuffleModeEnabledChangedEvent(
    val shuffleModeEnabled: Boolean
) : RxExoPlayerEvent()

class TimelineChangedEvent(
    val timeline: Timeline?,
    val manifest: Any?,
    val reason: Int
) : RxExoPlayerEvent()

class PlayerStateChangedEvent(
    val playWhenReady: Boolean,
    val playbackState: Int
) : RxExoPlayerEvent()
