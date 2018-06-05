package com.github.satoshun.reactivex.exoplayer2.internal

import com.github.satoshun.reactivex.exoplayer2.TracksChangedEvent
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.trackselection.TrackSelectionArray
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.MainThreadDisposable

internal class TracksChangedObservable(
    private val player: Player
) : Observable<TracksChangedEvent>() {
  override fun subscribeActual(observer: Observer<in TracksChangedEvent>) {
    val listener = Listener(observer, player)
    observer.onSubscribe(listener)
    player.addListener(listener)
  }

  private class Listener(
      private val observer: Observer<in TracksChangedEvent>,
      private val player: Player
  ) : MainThreadDisposable(),
      EmptyEventListener {

    override fun onTracksChanged(trackGroups: TrackGroupArray, trackSelections: TrackSelectionArray) {
      if (isDisposed) return
      observer.onNext(TracksChangedEvent(trackGroups, trackSelections))
    }

    override fun onDispose() {
      player.removeListener(this)
    }
  }
}
