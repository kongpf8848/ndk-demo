package io.github.kongpf8848.ndk.demo

import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import io.github.kongpf8848.ndk.demo.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        button1.setOnClickListener {
            jniIntArrayTest(intArrayOf(5,4,8))
        }

        button2.setOnClickListener {
            kotlinIntArrayTest()
        }

    }


    private external fun jniGetPackageName(context:Context): String
    private external fun jniGetSignature(context:Context):String
    private external fun jniIntArrayTest(array:IntArray)
    private external fun kotlinIntArrayTest()


    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }
}
