package io.github.kongpf8848.ndk.demo

import android.app.Application
import org.telegram.messenger.AndroidUtilities

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        AndroidUtilities.init(this)
    }
}