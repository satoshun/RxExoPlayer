package com.github.satoshun.reactivex.exoplayer2

import com.google.android.exoplayer2.Timeline

class TimelineChangedEvent(
    val timeline: Timeline,
    val manifest: Any
)
