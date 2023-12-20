package com.example.myapppabp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapppabp.databinding.ActivityMainBinding

class MainActivityAlarmManager : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_alarm_manager)
    }
}