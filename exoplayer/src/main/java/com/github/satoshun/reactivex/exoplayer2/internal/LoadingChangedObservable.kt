package com.github.satoshun.reactivex.exoplayer2.internal

import com.github.satoshun.reactivex.exoplayer2.LoadingChangedEvent
import com.google.android.exoplayer2.Player
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.MainThreadDisposable

internal class LoadingChangedObservable(
  private val player: Player
) : Observable<LoadingChangedEvent>() {
  override fun subscribeActual(observer: Observer<in LoadingChangedEvent>) {
    val listener = Listener(observer, player)
    observer.onSubscribe(listener)
    player.addListener(listener)
  }

  private class Listener(
    private val observer: Observer<in LoadingChangedEvent>,
    private val player: Player
  ) : MainThreadDisposable(),
      EmptyEventListener {

    override fun onLoadingChanged(isLoading: Boolean) {
      if (isDisposed) return
      observer.onNext(LoadingChangedEvent(isLoading))
    }

    override fun onDispose() {
      player.removeListener(this)
    }
  }
}
