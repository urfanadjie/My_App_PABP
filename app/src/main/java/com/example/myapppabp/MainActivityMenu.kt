package com.example.myapppabp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlin.system.exitProcess

class MainActivityMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val btnProfil3 = findViewById<Button>(R.id.btn_profil3)
        btnProfil3.setOnClickListener{
            Toast.makeText(this@MainActivityMenu, "Mengarahkan ke Profil Saya", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity4ProfilSaya::class.java)
            startActivity(intent)
        }

        val btnPert3 = findViewById<Button>(R.id.btn_pert3)
        btnPert3.setOnClickListener{
            Toast.makeText(this@MainActivityMenu, "Mengarahkan ke Pertemuan 3", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity1::class.java)
            startActivity(intent)
        }

        val btnPert4 = findViewById<Button>(R.id.btn_pert4)
        btnPert4.setOnClickListener{
            Toast.makeText(this@MainActivityMenu, "Mengarahkan ke Pertemuan 4", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivityDescBook::class.java)
            startActivity(intent)
        }

        val btnPert5 = findViewById<Button>(R.id.btn_pert5)
        btnPert5.setOnClickListener{
            Toast.makeText(this@MainActivityMenu, "Mengarahkan ke Pertemuan 5", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val btnExit = findViewById<Button>(R.id.btn_exit)
        btnExit.setOnClickListener{
            Toast.makeText(this@MainActivityMenu, "Keluar Aplikasi", Toast.LENGTH_SHORT).show()

            exitProcess(0)
        }
    }
}