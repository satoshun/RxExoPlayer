/**
Copyright (C) 2015 Jake Wharton

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package com.github.satoshun.reactivex.exoplayer2

import android.app.KeyguardManager
import android.content.Context.KEYGUARD_SERVICE
import android.content.Context.POWER_SERVICE
import android.os.PowerManager
import android.os.PowerManager.ACQUIRE_CAUSES_WAKEUP
import android.os.PowerManager.FULL_WAKE_LOCK
import android.os.PowerManager.ON_AFTER_RELEASE
import androidx.test.runner.AndroidJUnitRunner

class MyTestRunner : AndroidJUnitRunner() {
  private lateinit var wakeLock: PowerManager.WakeLock

  override fun onStart() {
    val app = targetContext.applicationContext

    val name = "MyTestRunner"
    // Unlock the device so that the tests can input keystrokes.
    val keyguard = app.getSystemService(KEYGUARD_SERVICE) as KeyguardManager
    keyguard.newKeyguardLock(name).disableKeyguard()
    // Wake up the screen.
    val power = app.getSystemService(POWER_SERVICE) as PowerManager
    wakeLock = power.newWakeLock(FULL_WAKE_LOCK or ACQUIRE_CAUSES_WAKEUP or ON_AFTER_RELEASE, name)
    wakeLock.acquire()

    super.onStart()
  }

  override fun onDestroy() {
    super.onDestroy()
    wakeLock.release()
  }
}
