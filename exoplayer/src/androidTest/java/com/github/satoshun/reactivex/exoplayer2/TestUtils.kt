package com.github.satoshun.reactivex.exoplayer2

import com.google.common.truth.Truth

fun <T> T?.isEqualTo(other: T?) = Truth.assertThat(this).isEqualTo(other)
fun <T> T?.isSameAs(other: T?) = Truth.assertThat(this).isSameAs(other)
fun Boolean?.isTrue() = Truth.assertThat(this).isTrue()
fun Boolean?.isFalse() = Truth.assertThat(this).isFalse()
fun <T> T?.isNull() = Truth.assertThat(this).isNull()

inline fun <reified T> List<Any>.containsIsInstanceOf() {
  val classList = this.map { it::class.java }
  Truth.assertThat(classList).contains(T::class.java)
}

inline fun <reified T> List<Any>.doesNotContainIsInstanceOf() {
  val classList = this.map { it::class.java }
  Truth.assertThat(classList).doesNotContain(T::class.java)
}

inline fun <reified T> Any.isInstanceOf() = Truth.assertThat(this).isInstanceOf(T::class.java)
