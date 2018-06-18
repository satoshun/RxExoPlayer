package com.github.satoshun.reactivex.exoplayer2.internal

import com.github.satoshun.reactivex.exoplayer2.LoadingChangedEvent
import com.github.satoshun.reactivex.exoplayer2.PlaybackParametersChangedEvent
import com.github.satoshun.reactivex.exoplayer2.PlayerErrorEvent
import com.github.satoshun.reactivex.exoplayer2.PlayerEvent
import com.github.satoshun.reactivex.exoplayer2.PlayerStateChangedEvent
import com.github.satoshun.reactivex.exoplayer2.PositionDiscontinuityEvent
import com.github.satoshun.reactivex.exoplayer2.RepeatModeChangedEvent
import com.github.satoshun.reactivex.exoplayer2.SeekProcessedEvent
import com.github.satoshun.reactivex.exoplayer2.ShuffleModeEnabledChangedEvent
import com.github.satoshun.reactivex.exoplayer2.TimelineChangedEvent
import com.github.satoshun.reactivex.exoplayer2.TracksChangedEvent
import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.PlaybackParameters
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.Timeline
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.trackselection.TrackSelectionArray
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.MainThreadDisposable

internal class PlayerEventsObservable(
    private val player: Player
) : Observable<PlayerEvent>() {
  override fun subscribeActual(observer: Observer<in PlayerEvent>) {
    val listener = Listener(observer, player)
    observer.onSubscribe(listener)
    player.addListener(listener)
  }

  private class Listener(
      private val observer: Observer<in PlayerEvent>,
      private val player: Player
  ) : MainThreadDisposable(),
      Player.EventListener {
    override fun onPlaybackParametersChanged(playbackParameters: PlaybackParameters) {
      if (isDisposed) return
      observer.onNext(PlaybackParametersChangedEvent(playbackParameters))
    }

    override fun onSeekProcessed() {
      if (isDisposed) return
      observer.onNext(SeekProcessedEvent)
    }

    override fun onTracksChanged(
        trackGroups: TrackGroupArray,
        trackSelections: TrackSelectionArray
    ) {
      if (isDisposed) return
      observer.onNext(TracksChangedEvent(trackGroups, trackSelections))
    }

    override fun onPlayerError(error: ExoPlaybackException) {
      if (isDisposed) return
      observer.onNext(PlayerErrorEvent(error))
    }

    override fun onLoadingChanged(isLoading: Boolean) {
      if (isDisposed) return
      observer.onNext(LoadingChangedEvent(isLoading))
    }

    override fun onPositionDiscontinuity(reason: Int) {
      if (isDisposed) return
      observer.onNext(PositionDiscontinuityEvent(reason))
    }

    override fun onRepeatModeChanged(repeatMode: Int) {
      if (isDisposed) return
      observer.onNext(RepeatModeChangedEvent(repeatMode))
    }

    override fun onShuffleModeEnabledChanged(shuffleModeEnabled: Boolean) {
      if (isDisposed) return
      observer.onNext(ShuffleModeEnabledChangedEvent(shuffleModeEnabled))
    }

    override fun onTimelineChanged(timeline: Timeline?, manifest: Any?, reason: Int) {
      if (isDisposed) return
      observer.onNext(TimelineChangedEvent(timeline, manifest, reason))
    }

    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
      if (isDisposed) return
      observer.onNext(PlayerStateChangedEvent(playWhenReady, playbackState))
    }

    override fun onDispose() {
      player.removeListener(this)
    }
  }
}
