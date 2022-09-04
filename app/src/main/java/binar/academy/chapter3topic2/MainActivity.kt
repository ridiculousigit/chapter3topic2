package binar.academy.chapter3topic2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menuBMI.setOnClickListener {
            val menu = Intent(this, BmiActivity :: class.java)
            startActivity(menu)
        }

    }
}