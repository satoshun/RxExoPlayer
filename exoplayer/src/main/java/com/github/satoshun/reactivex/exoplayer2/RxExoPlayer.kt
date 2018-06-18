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

object RxExoPlayer {
  @CheckResult
  fun events(player: Player): Observable<out RxExoPlayerEvent> {
    return RxExoPlayerEventsObservable(player)
  }

  @CheckResult
  fun playbackParametersChanged(player: Player): Observable<PlaybackParametersChangedEvent> {
    return PlaybackParametersChangedObservable(player)
  }

  @CheckResult
  fun seekProcessed(player: Player): Observable<SeekProcessedEvent> {
    return SeekProcessedObservable(player)
  }

  @CheckResult
  fun tracksChanged(player: Player): Observable<TracksChangedEvent> {
    return TracksChangedObservable(player)
  }

  @CheckResult
  fun playerError(player: Player): Observable<PlayerErrorEvent> {
    return PlayerErrorObservable(player)
  }

  @CheckResult
  fun loadingChanged(player: Player): Observable<LoadingChangedEvent> {
    return LoadingChangedObservable(player)
  }

  @CheckResult
  fun positionDiscontinuity(player: Player): Observable<PositionDiscontinuityEvent> {
    return PositionDiscontinuityObservable(player)
  }

  @CheckResult
  fun repeatModeChanged(player: Player): Observable<RepeatModeChangedEvent> {
    return RepeatModeChangedObservable(player)
  }

  @CheckResult
  fun shuffleModeEnabledChanged(player: Player): Observable<ShuffleModeEnabledChangedEvent> {
    return ShuffleModeEnabledChangedObservable(player)
  }

  @CheckResult
  fun timelineChanged(player: Player): Observable<TimelineChangedEvent> {
    return TimelineChangedObservable(player)
  }

  @CheckResult
  fun playerStateChanged(player: Player): Observable<PlayerStateChangedEvent> {
    return PlayerStateChangedObservable(player)
  }
}
