package com.example.myapppabp

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager

class BaseApplication : Application() {
    companion object {
        const val CHANNEL_1_ID = "channel1"
        const val CHANNEL_2_ID = "channel2"
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        //jika versi android berbeda atau diatasnya, kode ini di skip karena selalu nilai 30. jika berubah, maka berubah pula di android manifest
        //Membuat notifikasi channel 1
        val channel1 = NotificationChannel(
            CHANNEL_1_ID,
            "Kategori Satu",
            NotificationManager.IMPORTANCE_HIGH
        )
        channel1.description = "Ini adalah Kategori 1"

        //membuat notifikasi channel 2
        val channel2 = NotificationChannel (
            CHANNEL_2_ID,
            "Kategori Dua",
            NotificationManager.IMPORTANCE_HIGH
        )
        channel2.description = "Ini adalah Kategori 2"

        //membuat manager
        val manager = getSystemService(NotificationManager::class.java)
        manager?.createNotificationChannel(channel1)
        manager?.createNotificationChannel(channel2)
    }
}

//Kode percobaan, jangan di uncomment
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