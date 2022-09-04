package binar.academy.chapter3topic2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bmi.*

class BmiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        // Tombol Kembali ke MainActivity dengan Implicit Intent
        goHome_BMI.setOnClickListener {

            implicitIntent()

        }

        // Tombol Hitung dengan Explicit Intent
        btn_intentBMI.setOnClickListener {

            explicitIntent()

        }

        // Tombol Hitung dengan Bundle Intent
        btn_bundleBMI.setOnClickListener {

            bundleIntent()

        }

        // Tombol Hitung dengan Serializable
        btn_serializableBMI.setOnClickListener {

            serializable()

        }

        // Tombol Hitung dengan Parcelable
        btn_parcelableBMI.setOnClickListener {

            parcelable()

        }

        // Tombol Reset
        btn_resetBMI.setOnClickListener {

            reset()

        }

    }

    // Method untuk Implicit Intent
    fun implicitIntent() {

        val menu = Intent(this, MainActivity :: class.java)
        startActivity(menu)

    }

    // Method untuk Explicit Intent
    fun explicitIntent() {

        val umur = editUmur.text.toString()
        val tinggiBadan = editTB.text.toString()
        val beratBadan = editBB.text.toString()
        val bmi = hitungBMI(tinggiBadan.toDouble(), beratBadan.toDouble())
        val kategori = kategoriBerat(bmi)
        val intent = Intent(this, HasilBMIActivity :: class.java)

        intent.putExtra("age", umur)
        intent.putExtra("height", tinggiBadan)
        intent.putExtra("weight", beratBadan)
        intent.putExtra("bmi", String.format("%.2f", bmi))
        intent.putExtra("class", kategori)
        intent.putExtra("explicit", "true")
        startActivity(intent)

    }

    // Method untuk Bundle Intent
    private fun bundleIntent() {

        val umur = editUmur.text.toString()
        val tinggiBadan = editTB.text.toString()
        val beratBadan = editBB.text.toString()
        val bmi = hitungBMI(tinggiBadan.toDouble(), beratBadan.toDouble())
        val kategori = kategoriBerat(bmi)

        val bundling = Bundle()
        val intent = Intent(this, HasilBMIActivity :: class.java)
        bundling.putString("age", umur)
        bundling.putString("height", tinggiBadan)
        bundling.putString("weight", beratBadan)
        bundling.putString("ideal", String.format("%2.f", bmi))
        bundling.putString("category", kategori)
        intent.putExtra("bundle", "true")
        intent.putExtras(bundling)
        startActivity(intent)

    }

    // Method untuk Serializable
    private fun serializable() {

        val umur = editUmur.text.toString()
        val tinggiBadan = editTB.text.toString()
        val beratBadan = editBB.text.toString()
        val bmi = hitungBMI(tinggiBadan.toDouble(), beratBadan.toDouble())
        val kategori = kategoriBerat(bmi)

        val intent = Intent(this, HasilBMIActivity :: class.java)
        val serialization = HitungSerializable(umur, tinggiBadan, beratBadan, String.format("%2.f", bmi), kategori)
        intent.putExtra("serial", "true")
        intent.putExtra("dataser", serialization)
        startActivity(intent)

    }

    // Method untuk Parcelable
    private fun parcelable() {

        val umur = editUmur.text.toString()
        val tinggiBadan = editTB.text.toString()
        val beratBadan = editBB.text.toString()
        val bmi = hitungBMI(tinggiBadan.toDouble(), beratBadan.toDouble())
        val kategori = kategoriBerat(bmi)

        val intent = Intent(this, HasilBMIActivity :: class.java)
        val parcelization = HitungParcelable(umur, tinggiBadan, beratBadan, String.format("%2.f", bmi), kategori)
        intent.putExtra("parcel", "true")
        intent.putExtra("datapar", parcelization)
        startActivity(intent)

    }

    // Method Perhitungan BMI
    private fun hitungBMI(tinggiTubuh: Double, beratTubuh: Double): Double {

        return beratTubuh / ((tinggiTubuh * tinggiTubuh) / 10000)

    }

    // Method Klasifikasi BMI
    private fun kategoriBerat(BMI: Double):String {

        val kategori: String
        if (BMI >= 0 && BMI < 16) {
            kategori = "Terlalu Kurus"
        } else if (BMI in (16.0..17.0)) {
            kategori = "Cukup Kurus"
        } else if (BMI > 17 && BMI <= 18.5) {
            kategori = "Sedikit Kurus"
        } else if (BMI > 18.5 && BMI <= 25) {
            kategori = "Normal"
        } else if (BMI > 25 && BMI <= 30) {
            kategori = "Gemuk"
        } else if (BMI > 30 && BMI <= 35) {
            kategori = "Obesitas Kelas I"
        } else if (BMI > 35 && BMI <= 40) {
            kategori = "Obesitas Kelas II"
        } else if (BMI > 40 && BMI <= 50) {
            kategori = "Obesitas Kelas III"
        } else kategori = "Wah ! Mulai perhatikan pola makananmu ya :)"

        return kategori

    }

    // Method untuk Tombol Reset BMI
    private fun reset() {

        editUmur.setText("")
        editTB.setText("")
        editBB.setText("")

    }

}