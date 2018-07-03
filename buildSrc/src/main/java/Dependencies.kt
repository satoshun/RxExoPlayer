object Vers {
  val compile_sdk = 27
  val min_sdk = 16
  val target_sdk = 27
  val agp = "3.1.3"

  val kotlin = "1.2.50"
  val couroutine = "0.22.5"
  val support_lib = "27.1.1"
  val ktlint = "0.23.1"

  val exoplayer = "2.8.2"
}

object Libs {
  val android_plugin = "com.android.tools.build:gradle:${Vers.agp}"
  val kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Vers.kotlin}"
  val dokka_plugin = "org.jetbrains.dokka:dokka-android-gradle-plugin:0.9.16"

  val rx_java = "io.reactivex.rxjava2:rxjava:2.1.16"
  val rx_android = "io.reactivex.rxjava2:rxandroid:2.0.1"

  val exoplayer_core = "com.google.android.exoplayer:exoplayer-core:${Vers.exoplayer}"
  val exoplayer_hls = "com.google.android.exoplayer:exoplayer-hls:${Vers.exoplayer}"
  val exoplayer_ui = "com.google.android.exoplayer:exoplayer-ui:${Vers.exoplayer}"

  val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Vers.kotlin}"

  val design = "com.android.support:design:${Vers.support_lib}"
  val support_v4_core = "com.android.support:support-core-ui:${Vers.support_lib}"
  val appcompat_v7 = "com.android.support:appcompat-v7:${Vers.support_lib}"
  val constraint = "com.android.support.constraint:constraint-layout:1.0.2"
  val support_annotations = "com.android.support:support-annotations:${Vers.support_lib}"
  val recyclerview = "com.android.support:recyclerview-v7:${Vers.support_lib}"
  val constraint_layout = "com.android.support.constraint:constraint-layout:1.1.0"

  val viewmodel = "android.arch.lifecycle:viewmodel:1.1.1"
  val livedata = "android.arch.lifecycle:livedata:1.1.1"
  val gms = "com.google.android.gms:play-services-location:15.0.0"

  val junit = "junit:junit:4.12"
  val support_test = "com.android.support.test:runner:1.0.1"
  val espresso = "com.android.support.test.espresso:espresso-core:3.0.1"
  val arch_test = "android.arch.core:core-testing:1.1.1"

  val appcompat = "com.android.support:appcompat-v7:${Vers.support_lib}"
  val support_v4 = "com.android.support:support-v4:${Vers.support_lib}"

  val robolectric = "org.robolectric:robolectric:4.0-alpha-2"
  val android_test = "androidx.test:core:1.0.0-alpha3"
  val android_truth = "androidx.test.ext:truth:1.0.0-alpha3"
  val android_rules = "androidx.test:rules:1.1.0-alpha3"
  val android_runner = "androidx.test:runner:1.1.0-alpha3"
  val truth = "com.google.truth:truth:0.39"
  val mockito_kotlin = "com.nhaarman:mockito-kotlin-kt1.1:1.5.0"
  val multidex = "com.android.support:multidex:1.0.3"
}
