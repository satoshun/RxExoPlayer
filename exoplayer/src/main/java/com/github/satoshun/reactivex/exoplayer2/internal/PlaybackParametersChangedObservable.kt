package com.github.satoshun.reactivex.exoplayer2.internal

import com.github.satoshun.reactivex.exoplayer2.PlaybackParametersChangedEvent
import com.google.android.exoplayer2.PlaybackParameters
import com.google.android.exoplayer2.Player
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.MainThreadDisposable

internal class PlaybackParametersChangedObservable(
    private val player: Player
) : Observable<PlaybackParametersChangedEvent>() {
  override fun subscribeActual(observer: Observer<in PlaybackParametersChangedEvent>) {
    val listener = Listener(observer, player)
    observer.onSubscribe(listener)
    player.addListener(listener)
  }

  private class Listener(
      private val observer: Observer<in PlaybackParametersChangedEvent>,
      private val player: Player
  ) : MainThreadDisposable(),
      EmptyEventListener {
    override fun onPlaybackParametersChanged(playbackParameters: PlaybackParameters) {
      if (isDisposed) return
      observer.onNext(PlaybackParametersChangedEvent(
          playbackParameters))
    }

    override fun onDispose() {
      player.removeListener(this)
    }
  }
}
