package io.github.kongpf8848.ndk.demo

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button1.setOnClickListener {
            Toast.makeText(this@MainActivity,jniGetPackageName(applicationContext),Toast.LENGTH_SHORT).show()
        }

        button2.setOnClickListener {
            Toast.makeText(this@MainActivity,jniGetSignature(applicationContext),Toast.LENGTH_SHORT).show()
        }

        button3.setOnClickListener {
            Toast.makeText(this@MainActivity,Util.getAppSignature(applicationContext),Toast.LENGTH_SHORT).show()
        }

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    private external fun jniGetPackageName(context:Context): String
    private external fun jniGetSignature(context:Context):String


    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
