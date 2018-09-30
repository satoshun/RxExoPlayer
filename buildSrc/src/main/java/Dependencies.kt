object Vers {
  val compile_sdk = 28
  val min_sdk = 16
  val target_sdk = 28
  val agp = "3.2.0"

  val kotlin = "1.2.71"
  val ktlint = "0.24.0"

  val exoplayer = "2.8.4"
}

object Libs {
  val android_plugin = "com.android.tools.build:gradle:${Vers.agp}"
  val kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Vers.kotlin}"
  val ktlint_plugin = "gradle.plugin.org.jlleitschuh.gradle:ktlint-gradle:4.1.0"
  val dokka_plugin = "org.jetbrains.dokka:dokka-android-gradle-plugin:0.9.16"
  val publish_plugin = "com.vanniktech:gradle-maven-publish-plugin:0.6.0"

  val rx_java = "io.reactivex.rxjava2:rxjava:2.2.0"
  val rx_android = "io.reactivex.rxjava2:rxandroid:2.0.2"

  val exoplayer_core = "com.google.android.exoplayer:exoplayer-core:${Vers.exoplayer}"
  val exoplayer_hls = "com.google.android.exoplayer:exoplayer-hls:${Vers.exoplayer}"
  val exoplayer_ui = "com.google.android.exoplayer:exoplayer-ui:${Vers.exoplayer}"

  val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Vers.kotlin}"

  val appcompat = "androidx.appcompat:appcompat:1.0.0"
  val android_annotation = "androidx.annotation:annotation:1.0.0"

  val junit = "junit:junit:4.12"

  val android_rules = "androidx.test:rules:1.1.0-alpha4"
  val android_runner = "androidx.test:runner:1.1.0-alpha4"
  val truth = "com.google.truth:truth:0.42"
}
