package com.example.myapppabp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

@SuppressLint("CustomSplashScreen")
class MainSplashScreen : AppCompatActivity() {
    private val splashTimeOut : Long = 3000 //durasi waktu splash screen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_splash_screen)

        @Suppress("DEPRECATION")
        // kode ini untuk menunjukan bahwa fungsi sudah deprecated dan akan digunakan

        //Splash screeen main code
        Handler().postDelayed({
            //Kode ini akan dijalankan setelah timer selesai
            val  intent = Intent(this, MainActivityMenu::class.java) //Ganti dengan activity tujuan
            startActivity(intent)
            finish()
        }, splashTimeOut)
    }
}