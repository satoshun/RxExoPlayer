package com.github.satoshun.reactivex.exoplayer2

import androidx.annotation.CheckResult
import com.github.satoshun.reactivex.exoplayer2.internal.LoadingChangedObservable
import com.github.satoshun.reactivex.exoplayer2.internal.PlaybackParametersChangedObservable
import com.github.satoshun.reactivex.exoplayer2.internal.PlayerErrorObservable
import com.github.satoshun.reactivex.exoplayer2.internal.PlayerEventsObservable
import com.github.satoshun.reactivex.exoplayer2.internal.PlayerStateChangedObservable
import com.github.satoshun.reactivex.exoplayer2.internal.PositionDiscontinuityObservable
import com.github.satoshun.reactivex.exoplayer2.internal.RepeatModeChangedObservable
import com.github.satoshun.reactivex.exoplayer2.internal.SeekProcessedObservable
import com.github.satoshun.reactivex.exoplayer2.internal.ShuffleModeEnabledChangedObservable
import com.github.satoshun.reactivex.exoplayer2.internal.TimelineChangedObservable
import com.github.satoshun.reactivex.exoplayer2.internal.TracksChangedObservable
import com.google.android.exoplayer2.Player
import io.reactivex.Observable

/**
 * Create an observable for Player from Player.EventListener.
 */
@CheckResult
fun Player.events(): Observable<out PlayerEvent> {
  return PlayerEventsObservable(this)
}

/**
 * Create an observable for Player from Player.EventListener#onPlaybackParametersChanged.
 */
@CheckResult
fun Player.playbackParametersChanged(): Observable<PlaybackParametersChangedEvent> {
  return PlaybackParametersChangedObservable(this)
}

/**
 * Create an observable for Player from Player.EventListener#onSeekProcessed.
 */
@CheckResult
fun Player.seekProcessed(): Observable<SeekProcessedEvent> {
  return SeekProcessedObservable(this)
}

/**
 * Create an observable for Player from Player.EventListener#onTracksChanged.
 */
@CheckResult
fun Player.tracksChanged(): Observable<TracksChangedEvent> {
  return TracksChangedObservable(this)
}

/**
 * Create an observable for Player from Player.EventListener#onPlayerError.
 */
@CheckResult
fun Player.playerError(): Observable<PlayerErrorEvent> {
  return PlayerErrorObservable(this)
}

/**
 * Create an observable for Player from Player.EventListener#onLoadingChanged.
 */
@CheckResult
fun Player.loadingChanged(): Observable<LoadingChangedEvent> {
  return LoadingChangedObservable(this)
}

/**
 * Create an observable for Player from Player.EventListener#onPositionDiscontinuity.
 */
@CheckResult
fun Player.positionDiscontinuity(): Observable<PositionDiscontinuityEvent> {
  return PositionDiscontinuityObservable(this)
}

/**
 * Create an observable for Player from Player.EventListener#onRepeatModeChanged.
 */
@CheckResult
fun Player.repeatModeChanged(): Observable<RepeatModeChangedEvent> {
  return RepeatModeChangedObservable(this)
}

/**
 * Create an observable for Player from Player.EventListener#onShuffleModeEnabledChanged.
 */
@CheckResult
fun Player.shuffleModeEnabledChanged(): Observable<ShuffleModeEnabledChangedEvent> {
  return ShuffleModeEnabledChangedObservable(this)
}

/**
 * Create an observable for Player from Player.EventListener#onTimelineChanged.
 */
@CheckResult
fun Player.timelineChanged(): Observable<TimelineChangedEvent> {
  return TimelineChangedObservable(this)
}

/**
 * Create an observable for Player from Player.EventListener#onPlayerStateChanged.
 */
@CheckResult
fun Player.playerStateChanged(): Observable<PlayerStateChangedEvent> {
  return PlayerStateChangedObservable(this)
}
