package com.example.myapppabp

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.getSystemService
import com.example.myapppabp.databinding.ActivityMainBinding
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.util.Calendar

class MainActivityAlarmManager : AppCompatActivity() {

    private lateinit var picker : MaterialTimePicker
    private lateinit var calendar : Calendar
    private lateinit var alarmManager : AlarmManager
    private lateinit var pendingIntent: PendingIntent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_alarm_manager)

        val btnPilihWaktu = findViewById<Button>(R.id.btn_pilih_waktu)
        btnPilihWaktu.setOnClickListener {
            showTimePicker()
        }

        val btnAturWaktu = findViewById<Button>(R.id.btn_atur_waktu)
        btnAturWaktu.setOnClickListener {
            setAlarm()
        }

        val btnBatalAlarm = findViewById<Button>(R.id.btn_batalkan_alarm)
        btnBatalAlarm.setOnClickListener {
            batalkanAlarm()
        }

    }

    private fun batalkanAlarm() {
        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmReceiver::class.java)

        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        alarmManager.cancel(pendingIntent)

        Toast.makeText(this, "Alarm dibatalkan", Toast.LENGTH_LONG).show()
    }

    @SuppressLint("ScheduleExactAlarm")
    private fun setAlarm() {

        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmReceiver::class.java)

        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
        Toast.makeText(this, "Alarm telah diatur!.", Toast.LENGTH_SHORT).show()

    }

    @SuppressLint("SetTextI18n")
    private fun showTimePicker() {
        picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Tentukan waktu berikut!")
            .build()

        picker.show(supportFragmentManager, "channel2")

        picker.addOnPositiveButtonClickListener {
            if (picker.hour > 12) {
                val waktuDitentukan = findViewById<TextView>(R.id.waktu_ditentukan)
                waktuDitentukan.text =
                    String.format("%02d", picker.hour - 12) + " : " + String.format(
                        "%02d",
                        picker.minute
                    ) + " PM"
            } else {
                String.format("%02d", picker.hour) + " : " + String.format(
                    "%02d",
                    picker.minute
                ) + " AM"
            }

            calendar = Calendar.getInstance()
            calendar[Calendar.HOUR_OF_DAY] = picker.hour
            calendar[Calendar.MINUTE] = picker.minute
            calendar[Calendar.SECOND] = 0
            calendar[Calendar.MILLISECOND] = 0
        }
    }
}