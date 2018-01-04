package com.github.satoshun.reactivex.exoplayer2

import android.support.annotation.CheckResult
import android.support.annotation.NonNull

import com.google.android.exoplayer2.Player
import io.reactivex.Observable

object RxExoPlayer {
  @NonNull
  @CheckResult
  fun playbackParametersChanged(player: Player): Observable<PlaybackParametersChangedEvent> {
    return PlaybackParametersChangedObservable(player)
  }

  @NonNull
  @CheckResult
  fun seekProcessed(player: Player): Observable<SeekProcessedEvent> {
    return SeekProcessedObservable(player)
  }

  @NonNull
  @CheckResult
  fun tracksChanged(player: Player): Observable<TracksChangedEvent> {
    return TracksChangedObservable(player)
  }

  @NonNull
  @CheckResult
  fun playerError(player: Player): Observable<PlayerErrorEvent> {
    return PlayerErrorObservable(player)
  }

  @NonNull
  @CheckResult
  fun loadingChanged(player: Player): Observable<LoadingChangedEvent> {
    return LoadingChangedObservable(player)
  }

  @NonNull
  @CheckResult
  fun timelineChanged(player: Player): Observable<TimelineChangedEvent> {
    return TimelineChangedObservable(player)
  }
}
