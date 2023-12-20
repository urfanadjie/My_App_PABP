package com.example.myapppabp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivityNotification : AppCompatActivity() {

    private lateinit var notificationmanager : NotificationManagerCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_notification)

        //Kode membuat notifikasi di class baseapplication
        //inisialisasi notifikasi
        notificationmanager = NotificationManagerCompat.from(this)

        //val untuk kirim notifikasi bundle edittitle, editmessage
        val btnKirimNotif = findViewById<Button>(R.id.btn_lanjut_notif_1)
        val editTitle = "Test..1..2..3...Test!"
        val editMessage = "Diharapkan yang bernama Fulan agar ke sumber suara!."
        btnKirimNotif.setOnClickListener {

            //memanggil notifikasi builder (company objek)
            val builder = NotificationCompat.Builder(this, BaseApplication.CHANNEL_1_ID)

                //membuat icon dan set pengaturan notifikasi
                .setSmallIcon(R.drawable.baseline_add_alert_24)
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

        //intent ke message notification
        val btnLanjutNotifPesanCst = findViewById<Button>(R.id.btn_lanjut_pesan)
        btnLanjutNotifPesanCst.setOnClickListener {
            val intent = Intent(this, MainActivityMessageNotification::class.java)
            startActivity(intent)
        }
    }
}