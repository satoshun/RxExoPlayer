package com.github.satoshun.reactivex.exoplayer2.internal

import com.github.satoshun.reactivex.exoplayer2.PlayerStateChangedEvent
import com.google.android.exoplayer2.Player
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.MainThreadDisposable
internal class PlayerStateChangedObservable(
    private val player: Player
) : Observable<PlayerStateChangedEvent>() {
  override fun subscribeActual(observer: Observer<in PlayerStateChangedEvent>) {
    val listener = Listener(observer, player)
    observer.onSubscribe(listener)
    player.addListener(listener)
  }

  private class Listener(
      private val observer: Observer<in PlayerStateChangedEvent>,
      private val player: Player
  ) : MainThreadDisposable(),
      EmptyEventListener {
    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
      if (isDisposed) return
      observer.onNext(PlayerStateChangedEvent(playWhenReady, playbackState))
    }

    override fun onDispose() {
      player.removeListener(this)
    }
  }
}
