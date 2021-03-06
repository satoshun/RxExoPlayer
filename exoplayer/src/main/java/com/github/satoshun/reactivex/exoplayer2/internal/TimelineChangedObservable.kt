package com.github.satoshun.reactivex.exoplayer2.internal

import com.github.satoshun.reactivex.exoplayer2.TimelineChangedEvent
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.Timeline
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.MainThreadDisposable

internal class TimelineChangedObservable(
  private val player: Player
) : Observable<TimelineChangedEvent>() {
  override fun subscribeActual(observer: Observer<in TimelineChangedEvent>) {
    val listener = Listener(observer, player)
    observer.onSubscribe(listener)
    player.addListener(listener)
  }

  private class Listener(
    private val observer: Observer<in TimelineChangedEvent>,
    private val player: Player
  ) : MainThreadDisposable(),
      EmptyEventListener {
    override fun onTimelineChanged(timeline: Timeline?, manifest: Any?, reason: Int) {
      if (isDisposed) return
      observer.onNext(TimelineChangedEvent(timeline, manifest, reason))
    }

    override fun onDispose() {
      player.removeListener(this)
    }
  }
}
