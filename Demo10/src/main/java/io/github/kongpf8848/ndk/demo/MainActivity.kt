package io.github.kongpf8848.ndk.demo

import android.os.Bundle
import android.os.Looper
import android.os.MessageQueue
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.io.File


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener {
            testCrash()
        }
        Looper.myQueue().addIdleHandler {
            val file = File(applicationContext.externalCacheDir, "native_crash")
            if (!file.exists()) {
                file.mkdirs()
            }
            initBreakpad(file.absolutePath)
            false
        }


    }

    private external fun initBreakpad(path: String)
    private external fun testCrash()

    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }
}
