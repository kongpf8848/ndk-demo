package io.github.kongpf8848.ndk.demo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            val intent= Intent(this@MainActivity, TgsActivity::class.java)
            startActivity(intent)
        }
    }



    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
          System.loadLibrary("tmessages.40")
        }
    }
}
