package io.github.kongpf8848.ndk.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import io.github.kongpf8848.ndk.demo.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sample_text: TextView = findViewById(R.id.sample_text)
        sample_text.text = stringFromJNI()
    }

    external fun stringFromJNI(): String


    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }
}
