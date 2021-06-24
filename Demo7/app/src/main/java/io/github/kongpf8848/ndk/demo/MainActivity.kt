package io.github.kongpf8848.ndk.demo

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            jniIntArrayTest(intArrayOf(5,4,8))
        }

        button2.setOnClickListener {
            kotlinIntArrayTest()
        }

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    private external fun jniGetPackageName(context:Context): String
    private external fun jniGetSignature(context:Context):String
    private external fun jniIntArrayTest(array:IntArray)
    private external fun kotlinIntArrayTest()


    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
