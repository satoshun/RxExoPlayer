package com.github.satoshun.reactivex.exoplayer2.internal

import com.github.satoshun.reactivex.exoplayer2.RepeatModeChangedEvent
import com.google.android.exoplayer2.Player
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.MainThreadDisposable

internal class RepeatModeChangedObservable(
    private val player: Player
) : Observable<RepeatModeChangedEvent>() {
  override fun subscribeActual(observer: Observer<in RepeatModeChangedEvent>) {
    val listener = Listener(observer, player)
    observer.onSubscribe(listener)
    player.addListener(listener)
  }

  private class Listener(
      private val observer: Observer<in RepeatModeChangedEvent>,
      private val player: Player
  ) : MainThreadDisposable(),
      EmptyEventListener {

    override fun onRepeatModeChanged(repeatMode: Int) {
      if (isDisposed) return
      observer.onNext(RepeatModeChangedEvent(repeatMode))
    }

    override fun onDispose() {
      player.removeListener(this)
    }
  }
}
