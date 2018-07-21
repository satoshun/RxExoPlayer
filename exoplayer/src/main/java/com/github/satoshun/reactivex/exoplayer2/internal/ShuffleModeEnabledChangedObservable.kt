package com.github.satoshun.reactivex.exoplayer2.internal

import com.github.satoshun.reactivex.exoplayer2.ShuffleModeEnabledChangedEvent
import com.google.android.exoplayer2.Player
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.MainThreadDisposable

internal class ShuffleModeEnabledChangedObservable(
  private val player: Player
) : Observable<ShuffleModeEnabledChangedEvent>() {
  override fun subscribeActual(observer: Observer<in ShuffleModeEnabledChangedEvent>) {
    val listener = Listener(observer, player)
    observer.onSubscribe(listener)
    player.addListener(listener)
  }

  private class Listener(
    private val observer: Observer<in ShuffleModeEnabledChangedEvent>,
    private val player: Player
  ) : MainThreadDisposable(),
      EmptyEventListener {

    override fun onShuffleModeEnabledChanged(shuffleModeEnabled: Boolean) {
      if (isDisposed) return
      observer.onNext(ShuffleModeEnabledChangedEvent(shuffleModeEnabled))
    }

    override fun onDispose() {
      player.removeListener(this)
    }
  }
}
