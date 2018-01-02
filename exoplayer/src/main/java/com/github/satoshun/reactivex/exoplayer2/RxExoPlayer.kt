package com.github.satoshun.reactivex.exoplayer2

import android.support.annotation.CheckResult
import android.support.annotation.NonNull

import com.google.android.exoplayer2.Player
import io.reactivex.Observable

object RxExoPlayer {
  @NonNull
  @CheckResult
  fun timelineChanged(player: Player): Observable<TimelineChangedEvent> {
    return TimelineChangedObservable(player)
  }

  @NonNull
  @CheckResult
  fun playbackParametersChanged(player: Player): Observable<PlaybackParametersChangedEvent> {
    return PlaybackParametersChangedObservable(player)
  }
}
