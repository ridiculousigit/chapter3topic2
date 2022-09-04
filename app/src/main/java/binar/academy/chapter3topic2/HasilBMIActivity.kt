package binar.academy.chapter3topic2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bmi.*
import kotlinx.android.synthetic.main.activity_hasil_bmiactivity.*

class HasilBMIActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_bmiactivity)

        goHome_hasil.setOnClickListener {

            val menu = Intent(this, BmiActivity :: class.java)
            startActivity(menu)

        }

        if (intent.getStringExtra("explicit") == "true") {
            getExplicit()
        } else if (intent.getStringExtra("bundle") == "true") {
            getBundle()
        } else if (intent.getStringExtra("serial") == "true") {
            getSerializable()
        }

    }

    private fun getExplicit() {

        val age = intent.getStringExtra("age")
        val height = intent.getStringExtra("height")
        val weight = intent.getStringExtra("weight")
        val ideal = intent.getStringExtra("bmi")
        val grade = intent.getStringExtra("class")

        hasilUmur.text = age
        hasilTB.text = height
        hasilBB.text = weight
        hasilBMI.text = ideal
        hasilKategori.text = grade

    }

    fun getBundle() {

        val bundle = intent.extras
        hasilUmur.setText(bundle!!.getString("age"))
        hasilTB.setText(bundle.getString("height"))
        hasilBB.setText(bundle.getString("weight"))
        hasilBMI.setText(bundle.getString("ideal"))
        hasilKategori.setText(bundle.getString("category"))

    }

    fun getSerializable() {

        val dataser = intent.getSerializableExtra("dataser") as HitungSerializable
        hasilUmur.text = dataser.dataUmur
        hasilTB.text = dataser.dataTinggi
        hasilBB.text = dataser.dataBerat
        hasilBMI.text = dataser.dataIdeal
        hasilKategori.text = dataser.dataCategori

    }

    fun getParcelable() {

        val datapar = intent.getParcelableExtra("datapar") as HitungParcelable?

        hasilUmur.text = datapar!!.dataUmur
        hasilTB.text = datapar.dataTinggi
        hasilBB.text = datapar.dataBerat
        hasilBMI.text = datapar.dataIdeal
        hasilKategori.text = datapar.dataCategori

    }

}