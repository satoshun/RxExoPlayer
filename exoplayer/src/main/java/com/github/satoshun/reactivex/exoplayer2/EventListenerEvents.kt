package com.github.satoshun.reactivex.exoplayer2

import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.PlaybackParameters
import com.google.android.exoplayer2.Timeline
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.trackselection.TrackSelectionArray

/**
 * A event on Player
 */
sealed class PlayerEvent

/**
 * A event on Player#onPlaybackParametersChanged
 */
class PlaybackParametersChangedEvent(
    val playbackParameters: PlaybackParameters
) : PlayerEvent()

/**
 * A event on Player#onSeekProcessed
 */
object SeekProcessedEvent : PlayerEvent()

/**
 * A event on Player#onTracksChanged
 */
class TracksChangedEvent(
    val trackGroups: TrackGroupArray,
    val trackSelections: TrackSelectionArray
) : PlayerEvent()

/**
 * A event on Player#onPlayerError
 */
class PlayerErrorEvent(
    val error: ExoPlaybackException
) : PlayerEvent()

/**
 * A event on Player#onLoadingChanged
 */
class LoadingChangedEvent(
    val isLoading: Boolean
) : PlayerEvent()

/**
 * A event on Player#onPositionDiscontinuity
 */
class PositionDiscontinuityEvent(
    val reason: Int
) : PlayerEvent()

/**
 * A event on Player#onRepeatModeChanged
 */
class RepeatModeChangedEvent(
    val repeatMode: Int
) : PlayerEvent()

/**
 * A event on Player#onShuffleModeEnabledChanged
 */
class ShuffleModeEnabledChangedEvent(
    val shuffleModeEnabled: Boolean
) : PlayerEvent()

/**
 * A event on Player#onTimelineChanged
 */
class TimelineChangedEvent(
    val timeline: Timeline?,
    val manifest: Any?,
    val reason: Int
) : PlayerEvent()

/**
 * A event on Player#onPlayerStateChanged
 */
class PlayerStateChangedEvent(
    val playWhenReady: Boolean,
    val playbackState: Int
) : PlayerEvent()
