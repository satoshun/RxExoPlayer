package com.github.satoshun.reactivex.exoplayer2

import android.support.annotation.CheckResult
import com.github.satoshun.reactivex.exoplayer2.internal.LoadingChangedObservable
import com.github.satoshun.reactivex.exoplayer2.internal.PlaybackParametersChangedObservable
import com.github.satoshun.reactivex.exoplayer2.internal.PlayerErrorObservable
import com.github.satoshun.reactivex.exoplayer2.internal.PlayerStateChangedObservable
import com.github.satoshun.reactivex.exoplayer2.internal.PositionDiscontinuityObservable
import com.github.satoshun.reactivex.exoplayer2.internal.RepeatModeChangedObservable
import com.github.satoshun.reactivex.exoplayer2.internal.RxExoPlayerEventsObservable
import com.github.satoshun.reactivex.exoplayer2.internal.SeekProcessedObservable
import com.github.satoshun.reactivex.exoplayer2.internal.ShuffleModeEnabledChangedObservable
import com.github.satoshun.reactivex.exoplayer2.internal.TimelineChangedObservable
import com.github.satoshun.reactivex.exoplayer2.internal.TracksChangedObservable
import com.google.android.exoplayer2.Player
import io.reactivex.Observable

@CheckResult
fun Player.events(): Observable<out RxExoPlayerEvent> {
  return RxExoPlayerEventsObservable(this)
}

@CheckResult
fun Player.playbackParametersChanged(): Observable<PlaybackParametersChangedEvent> {
  return PlaybackParametersChangedObservable(this)
}

@CheckResult
fun Player.seekProcessed(): Observable<SeekProcessedEvent> {
  return SeekProcessedObservable(this)
}

@CheckResult
fun Player.tracksChanged(): Observable<TracksChangedEvent> {
  return TracksChangedObservable(this)
}

@CheckResult
fun Player.playerError(): Observable<PlayerErrorEvent> {
  return PlayerErrorObservable(this)
}

@CheckResult
fun Player.loadingChanged(): Observable<LoadingChangedEvent> {
  return LoadingChangedObservable(this)
}

@CheckResult
fun Player.positionDiscontinuity(): Observable<PositionDiscontinuityEvent> {
  return PositionDiscontinuityObservable(this)
}

@CheckResult
fun Player.repeatModeChanged(): Observable<RepeatModeChangedEvent> {
  return RepeatModeChangedObservable(this)
}

@CheckResult
fun Player.shuffleModeEnabledChanged(): Observable<ShuffleModeEnabledChangedEvent> {
  return ShuffleModeEnabledChangedObservable(this)
}

@CheckResult
fun Player.timelineChanged(): Observable<TimelineChangedEvent> {
  return TimelineChangedObservable(this)
}

@CheckResult
fun Player.playerStateChanged(): Observable<PlayerStateChangedEvent> {
  return PlayerStateChangedObservable(this)
}
