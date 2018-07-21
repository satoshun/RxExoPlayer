package com.github.satoshun.reactivex.exoplayer2.internal

import com.github.satoshun.reactivex.exoplayer2.SeekProcessedEvent
import com.google.android.exoplayer2.Player
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.MainThreadDisposable

internal class SeekProcessedObservable(
  private val player: Player
) : Observable<SeekProcessedEvent>() {
  override fun subscribeActual(observer: Observer<in SeekProcessedEvent>) {
    val listener = Listener(observer, player)
    observer.onSubscribe(listener)
    player.addListener(listener)
  }

  private class Listener(
    private val observer: Observer<in SeekProcessedEvent>,
    private val player: Player
  ) : MainThreadDisposable(),
      EmptyEventListener {
    override fun onSeekProcessed() {
      if (isDisposed) return
      observer.onNext(SeekProcessedEvent)
    }

    override fun onDispose() {
      player.removeListener(this)
    }
  }
}
