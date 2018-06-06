package com.github.satoshun.reactivex.exoplayer2.hls

import com.github.satoshun.reactivex.exoplayer2.hls.internal.MediaSourceEventObservable
import com.google.android.exoplayer2.source.MediaSourceEventListener
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

fun rxMediaSourceEvent(): Pair<Observable<MediaSourceEvent>, MediaSourceEventListener> {
  val subject = PublishSubject.create<MediaSourceEvent>()
  return subject.hide() to MediaSourceEventObservable(subject)
}
