package io.github.kongpf8848.ndk.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * kotlin调用C++代码
         */
        kotlin_call_cplusplus.setOnClickListener {
            Toast.makeText(this@MainActivity,stringFromJNI(),Toast.LENGTH_SHORT).show()
        }
        /**
         *  kotlin调用C++代码,C++代码再调用kotlin代码
         */
        cplusplus_call_kotlin.setOnClickListener {
            Toast.makeText(this@MainActivity,stringFromKotlin(),Toast.LENGTH_SHORT).show()
        }

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String
    external fun stringFromKotlin():String


    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
