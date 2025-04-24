package io.github.kongpf8848.ndk.demo

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.github.kongpf8848.ndk.demo.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)

        button1.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                jniGetPackageName(applicationContext),
                Toast.LENGTH_SHORT
            ).show()
        }

        button2.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                jniGetSignature(applicationContext),
                Toast.LENGTH_SHORT
            ).show()
        }

        button3.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                Util.getAppSignature(applicationContext),
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    private external fun jniGetPackageName(context: Context): String
    private external fun jniGetSignature(context: Context): String


    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }
}
