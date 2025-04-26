package io.github.kongpf8848.ndk.demo

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Looper
import android.os.MessageQueue
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.io.File


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener {
            initPath()
            testCrash()
        }
        if (ActivityCompat.checkSelfPermission(this@MainActivity,Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                100
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==100 && grantResults[0]== Activity.RESULT_OK) {
            initPath()
        }
    }

    private fun initPath(){
        val file = File(applicationContext.externalCacheDir, "crash")
        if (!file.exists()) {
            file.mkdirs()
        }
        initBreakpad(file.absolutePath)
    }

    private external fun initBreakpad(path: String)
    private external fun testCrash()

    companion object {
        init {
            System.loadLibrary("breakpad")
            System.loadLibrary("native-lib")
        }
    }
}
