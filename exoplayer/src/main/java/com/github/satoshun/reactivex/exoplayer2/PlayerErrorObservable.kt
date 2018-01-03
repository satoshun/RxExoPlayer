package com.github.satoshun.reactivex.exoplayer2

import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.Player
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.MainThreadDisposable

internal class PlayerErrorObservable(
    private val player: Player
) : Observable<PlayerErrorEvent>() {
  override fun subscribeActual(observer: Observer<in PlayerErrorEvent>) {
    val listener = Listener(observer, player)
    observer.onSubscribe(listener)
    player.addListener(listener)
  }

  private class Listener(
      private val observer: Observer<in PlayerErrorEvent>,
      private val player: Player
  ) : MainThreadDisposable(),
      EmptyEventListener {

    override fun onPlayerError(error: ExoPlaybackException) {
      if (isDisposed) return
      observer.onNext(PlayerErrorEvent(error))
    }

    override fun onDispose() {
      player.removeListener(this)
    }
  }
}
