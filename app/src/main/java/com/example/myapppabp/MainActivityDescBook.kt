package com.example.myapppabp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivityDescBook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val buttondeskripsi = findViewById<Button>(R.id.button_deskripsi)

        buttondeskripsi.setOnClickListener{
            Toast.makeText(this@MainActivityDescBook, "Success", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val buttonig = findViewById<Button>(R.id.button_sosmed_IG)

        buttonig.setOnClickListener{
            val url = "https://www.instagram.com/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        val buttonphone = findViewById<Button>(R.id.button_phone)

        buttonphone.setOnClickListener {
            val phoneNumber = "085155334028"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(intent)
        }
    }
}