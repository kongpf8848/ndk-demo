package io.github.kongpf8848.ndk.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import io.github.kongpf8848.ndk.demo.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sample_text_1:TextView=findViewById(R.id.sample_text_1)
        val sample_text_2:TextView=findViewById(R.id.sample_text_2)
        sample_text_1.text = stringFromJNI1()
        sample_text_2.text = stringFromJNI2()
    }

    external fun stringFromJNI1(): String
    external fun stringFromJNI2(): String

    companion object {
        init {
            System.loadLibrary("one-lib")
            System.loadLibrary("two-lib")
        }
    }
}
