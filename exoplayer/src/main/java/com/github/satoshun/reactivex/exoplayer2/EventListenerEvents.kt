package com.github.satoshun.reactivex.exoplayer2

import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.PlaybackParameters
import com.google.android.exoplayer2.Timeline
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.trackselection.TrackSelectionArray

class PlaybackParametersChangedEvent(
    val playbackParameters: PlaybackParameters
)

object SeekProcessedEvent

class TracksChangedEvent(
    val trackGroups: TrackGroupArray,
    val trackSelections: TrackSelectionArray
)

class PlayerErrorEvent(
    val error: ExoPlaybackException
)

class LoadingChangedEvent(
    val isLoading: Boolean
)

class PositionDiscontinuityEvent(
    val reason: Int
)

class RepeatModeChangedEvent(
    val repeatMode: Int
)

class ShuffleModeEnabledChangedEvent(
    val shuffleModeEnabled: Boolean
)

class TimelineChangedEvent(
    val timeline: Timeline,
    val manifest: Any
)

class PlayerStateChangedEvent(
    val playWhenReady: Boolean,
    val playbackState: Int
)
