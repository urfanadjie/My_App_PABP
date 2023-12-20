package com.example.myapppabp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

@Suppress("DEPRECATION")
class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        //jika dengan intent tanpa bundle
//        val intentfromActNew2 = intent
//
//        if (intentfromActNew2 != null) {
//
//            //Ambil data dari activity sebelumnya
//            val username = intentfromActNew2.getStringExtra("USERNAME")
//            val password = intentfromActNew2.getStringExtra("PASSWORD")
//
//            //Definis view
//            val textViewUser = findViewById<TextView>(R.id.tv_username)
//            val textViewPassword = findViewById<TextView>(R.id.tv_password)
//
//            //variabel kan ke view
//            textViewUser.text = "$username"
//            textViewPassword.text = "$password"
//        }

//        //jika gunakan bundle
//        val bundle = intent.extras
//
//        if (bundle != null) {
//            //Ambil data dari activity sebelumnya dgn bundle
//            val username = bundle.getString("USERNAME")
//            val password = bundle.getString("PASSWORD")
//
//            //Definis view dgn bundle
//            val textViewUser = findViewById<TextView>(R.id.tv_username)
//            val textViewPassword = findViewById<TextView>(R.id.tv_password)
//
//            //variabel kan ke view dgn bundle
//            textViewUser.text = "$username"
//            textViewPassword.text = "$password"

        //Jika gunakan Parcelable
        val userData = intent.getParcelableExtra<MainActivity3UserData>(/* name = */ "USER_DATA")

        if (userData != null) {
            //Definisi view dgn parcelable
            val textViewUser = findViewById<TextView>(R.id.tv_username)
            val textViewPassword = findViewById<TextView>(R.id.tv_password)

            //Tampil data ke tv layout dr parcelable
            textViewUser.text = "${userData.username}"
            textViewPassword.text = "${userData.password}"
        }

        val buttonLanjutNotifikasi = findViewById<Button>(R.id.btn_lanjut_ke_notif)
        buttonLanjutNotifikasi.setOnClickListener{
            Toast.makeText(this@MainActivity3, "Suwun!.", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivityNotification::class.java)
            startActivity(intent)
        }
    }
}