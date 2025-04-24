package io.github.kongpf8848.ndk.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import io.github.kongpf8848.ndk.demo.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val kotlin_call_cplusplus: Button = findViewById(R.id.kotlin_call_cplusplus)
        val cplusplus_call_kotlin: Button = findViewById(R.id.cplusplus_call_kotlin)
        /**
         * kotlin调用C++代码
         */
        kotlin_call_cplusplus.setOnClickListener {
            Toast.makeText(this@MainActivity, stringFromJNI(), Toast.LENGTH_SHORT).show()
        }
        /**
         *  kotlin调用C++代码,C++代码再调用kotlin代码
         */
        cplusplus_call_kotlin.setOnClickListener {
            Toast.makeText(this@MainActivity, stringFromKotlin(), Toast.LENGTH_SHORT).show()
        }

    }

    external fun stringFromJNI(): String
    external fun stringFromKotlin(): String


    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }
}
