package com.github.satoshun.reactivex.exoplayer2.source

import android.os.Handler
import android.support.annotation.CheckResult
import com.github.satoshun.reactivex.exoplayer2.source.internal.MediaSourceEventObservable
import com.google.android.exoplayer2.source.MediaSource
import io.reactivex.Observable

/**
 * Create an observable for MediaSource from MediaSourceEventListener.
 */
@CheckResult
fun MediaSource.events(handler: Handler = Handler()): Observable<MediaSourceEvent> {
  return MediaSourceEventObservable(this, handler)
}
