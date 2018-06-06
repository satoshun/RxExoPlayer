package com.github.satoshun.reactivex.exoplayer2.hls

import com.github.satoshun.reactivex.exoplayer2.hls.internal.MediaSourceEventObservable
import com.google.android.exoplayer2.source.MediaSource
import io.reactivex.Observable

fun MediaSource.events(): Observable<MediaSourceEvent> {
  return MediaSourceEventObservable(this)
}
