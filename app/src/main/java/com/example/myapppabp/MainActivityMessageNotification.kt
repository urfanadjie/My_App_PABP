package com.example.myapppabp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivityMessageNotification : AppCompatActivity() {

    private lateinit var notificationmanager : NotificationManagerCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_message_notification)

        //inisialisasi notifikasi
        notificationmanager = NotificationManagerCompat.from(this)

        //val untuk kirim notifikasi bundle edittitle, editmessage utk btn kategori 1
        val btnNotifKategori1 = findViewById<Button>(R.id.btn_notif_cat_1)
        val editTitle = findViewById<EditText>(R.id.edittext_title_notif_1)
        val editMessage = findViewById<EditText>(R.id.edittext_message_notif_1)
        btnNotifKategori1.setOnClickListener {
            //ini uncomment apabila ada edittext di view tersendiri
          val title = editTitle.text.toString()
          val message = editMessage.text.toString()

            //memanggil notifikasi builder (company objek)
            val builder = NotificationCompat.Builder(this, BaseApplication.CHANNEL_1_ID)

                //membuat icon dan set pengaturan notifikasi
                .setSmallIcon(R.drawable.baseline_add_alert_24)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE) //kategori

            //membuat notifikasi untuk di builder
            val notifikasi = builder.build()

            //Granting Permission for Newer Android
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

        //val untuk kirim notifikasi bundle edittitle, editmessage utk btn kategori 2
        val btnNotifKategori2 = findViewById<Button>(R.id.btn_notif_cat_2)
        val editTitle2 = findViewById<EditText>(R.id.edittext_title_notif_2)
        val editMessage2 = findViewById<EditText>(R.id.edittext_message_notif_2)
        btnNotifKategori2.setOnClickListener {
            //ini uncomment apabila ada edittext di view tersendiri
            val title = editTitle2.text.toString()
            val message = editMessage2.text.toString()

            //memanggil notifikasi builder (company objek)
            val builder = NotificationCompat.Builder(this, BaseApplication.CHANNEL_1_ID)

                //membuat icon dan set pengaturan notifikasi
                .setSmallIcon(R.drawable.baseline_add_alert_24)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE) //kategori

            //membuat notifikasi untuk di builder
            val notifikasi = builder.build()

            //Granting Permission for Newer Android
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

        // Intent utk lanjut ke alarm notification
        val btnLanjutAlarmNotification = findViewById<Button>(R.id.btn_lanjut_message_notif)
        btnLanjutAlarmNotification.setOnClickListener{
            val intent = Intent(this, MainActivityAlarmManager::class.java)
            startActivity(intent)
        }
    }
}