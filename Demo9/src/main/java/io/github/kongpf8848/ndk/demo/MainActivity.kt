package io.github.kongpf8848.ndk.demo

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1: Button = findViewById(R.id.button1)


        button1.setOnClickListener {
           testCrash()
        }


    }

    private external fun testCrash(): Unit

    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }
}
