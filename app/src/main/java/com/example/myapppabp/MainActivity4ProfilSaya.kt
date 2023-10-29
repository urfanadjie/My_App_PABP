package com.example.myapppabp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity4ProfilSaya : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity4_profil_saya)

        val imagebtnInstagram = findViewById<ImageView>(R.id.click_instagram)
        imagebtnInstagram.setOnClickListener{
            Toast.makeText(this@MainActivity4ProfilSaya, "Membuka Instagram", Toast.LENGTH_SHORT).show()

            val webURL = "https://www.instagram.com/urfanadjie/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(webURL))
            intent.setPackage("com.instagram.android")
            startActivity(intent)
        }

        val imagebtnPhone = findViewById<ImageView>(R.id.click_phone)
        imagebtnPhone.setOnClickListener{
            Toast.makeText(this@MainActivity4ProfilSaya, "Membuka Telepon", Toast.LENGTH_SHORT).show()

            val phoneNumber = "085155334028"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(intent)
        }

        val imagebtnWhatsapp = findViewById<ImageView>(R.id.click_whatsapp)
        imagebtnWhatsapp.setOnClickListener{
            Toast.makeText(this@MainActivity4ProfilSaya, "Alihkan Chrome WhatsApp", Toast.LENGTH_SHORT).show()

            val webURL = "https://wa.me/6285155334028/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(webURL))
            startActivity(intent)
        }
    }
}