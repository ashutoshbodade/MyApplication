package `in`.arambh.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var num : Int = 0

        btnCount.setOnClickListener {
            num = num + 2
            txtCount.text = num.toString()
        }

        val btnct = btnCount

        //var a = txtCount.text       // get text

       // txtCount.text = "some text" // set text

       /* btnct.setOnClickListener {
            txtCount.text = "some text"
        }*/




    }
}
