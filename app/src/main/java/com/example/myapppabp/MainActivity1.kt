package com.example.myapppabp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editAlas = findViewById<EditText>(R.id.editAlas)
        val editTinggi = findViewById<EditText>(R.id.editTinggi)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val textHasil = findViewById<TextView>(R.id.tvHasil)

        //Memanggil resources pada string.xml
        //val hasilSegitiga = getString(R.string.hasil_luas_segitiga_mainActivity)

        btnSubmit.setOnClickListener{
            //Mengambil nilai alas dan tinggi dari EditText
            val alas = editAlas.text.toString().toDoubleOrNull()
            val tinggi = editTinggi.text.toString().toDoubleOrNull()

            //Memeriksa apakah input valid
            if (alas != null && tinggi != null) {
                //Menghitung luas segitiga
                val luas = 0.5 * alas * tinggi
                textHasil.text = "$luas"

                //Menampilkan hasil menggunakan Toast
                Toast.makeText(this@MainActivity1, "Luas Segitiga: $luas", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity1, "Masukkan angka yang valid untuk alas dan tinggi", Toast.LENGTH_SHORT).show()
            }
        }
    }
}