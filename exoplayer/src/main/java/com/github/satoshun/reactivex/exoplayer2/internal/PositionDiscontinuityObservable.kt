package com.github.satoshun.reactivex.exoplayer2.internal

import com.github.satoshun.reactivex.exoplayer2.PositionDiscontinuityEvent
import com.google.android.exoplayer2.Player
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.MainThreadDisposable

internal class PositionDiscontinuityObservable(
    private val player: Player
) : Observable<PositionDiscontinuityEvent>() {
  override fun subscribeActual(observer: Observer<in PositionDiscontinuityEvent>) {
    val listener = Listener(observer, player)
    observer.onSubscribe(listener)
    player.addListener(listener)
  }

  private class Listener(
      private val observer: Observer<in PositionDiscontinuityEvent>,
      private val player: Player
  ) : MainThreadDisposable(),
      EmptyEventListener {

    override fun onPositionDiscontinuity(reason: Int) {
      if (isDisposed) return
      observer.onNext(PositionDiscontinuityEvent(reason))
    }

    override fun onDispose() {
      player.removeListener(this)
    }
  }
}
