package com.example.myapppabp

import android.Manifest
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Build.VERSION_CODES.O
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlin.system.exitProcess

class MainActivityMenu : AppCompatActivity() {

    //Deklarasi val untuk channel id notification kotlin
//    private val CHANNEL_ID = "channel_id_example_01"
//    private val notificationId = 101
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

        //Kode untuk notfikasi dan deklarasi class createnotification
        val btnPert8 = findViewById<Button>(R.id.btn_pert8)

        //jalankan fungsi notifikasi
//        createNotificationChannel()

        btnPert8.setOnClickListener {
//            sendNotification()
        }

        val btnExit = findViewById<Button>(R.id.btn_exit)
        btnExit.setOnClickListener{
            Toast.makeText(this@MainActivityMenu, "Keluar Aplikasi", Toast.LENGTH_SHORT).show()

            exitProcess(0)
        }
    }

//    private fun createNotificationChannel() {
//        val name = "Notification Title"
//        val descriptionText = "Notification Description"
//        val importance = NotificationManager.IMPORTANCE_DEFAULT
//        val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
//            description = descriptionText
//        }
//        val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        notificationManager.createNotificationChannel(channel)
//
//    }
//    private fun sendNotification() {
//        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
//            .setSmallIcon(R.drawable.ic_launcher_background)
//            .setContentTitle("Example Title")
//            .setContentText("Example Description")
//            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//
////        with(NotificationManagerCompat.from(this)) {
////            notify(notificationId, builder.build())
//        }
    }