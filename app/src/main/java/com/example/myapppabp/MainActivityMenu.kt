package com.example.myapppabp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlin.system.exitProcess

class MainActivityMenu : AppCompatActivity() {

    //Deklarasi val untuk notificationmanager
    private lateinit var notificationmanager : NotificationManagerCompat

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

        //Kode membuat notifikasi di class baseapplication
        //inisialisasi notifikasi
        notificationmanager = NotificationManagerCompat.from(this)

        //val untuk kirim notifikasi bundle edittitle, editmessage
        val btnPert8 = findViewById<Button>(R.id.btn_pert8)
        val editTitle = "Ini adalah Judul dari notifikasi"
        val editMessage = "Ini adalah pesan dari notifikasi"
        btnPert8.setOnClickListener {
            //ini uncomment apabila ada edittext di view tersendiri
//          val title = editTitle.text.toString()
//          val message = editMessage.text.toString()

            //memanggil notifikasi builder (company objek)
            val builder = NotificationCompat.Builder(this, BaseApplication.CHANNEL_1_ID)

            //membuat icon dan set pengaturan notifikasi
                .setSmallIcon(R.drawable.person_icon)
                .setContentTitle(editTitle)
                .setContentText(editMessage)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE) //kategori

            //membuat notifikasi untuk di builder
            val notifikasi = builder.build()
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    ActivityCompat.requestPermissions(this, (arrayOf(Manifest.permission.POST_NOTIFICATIONS)), 0)
                }
            }
            this.notificationmanager.notify(1, notifikasi)

        }

        val buttonAPI = findViewById<Button>(R.id.btn_get_api)
        buttonAPI.setOnClickListener {
            val intent = Intent(this, MainApi::class.java)
            startActivity(intent)
        }

        val btnExit = findViewById<Button>(R.id.btn_exit)
        btnExit.setOnClickListener{
            Toast.makeText(this@MainActivityMenu, "Keluar Aplikasi", Toast.LENGTH_SHORT).show()

            exitProcess(0)
        }
    }
}