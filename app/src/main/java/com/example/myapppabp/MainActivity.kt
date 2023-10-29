package com.example.myapppabp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

//import android.widget.EditText
//import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_2)

        val buttonLogin2 = findViewById<Button>(R.id.button)
        buttonLogin2.setOnClickListener{
            Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        val buttonIG3 = findViewById<Button>(R.id.button2)
        buttonIG3.setOnClickListener{
            Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()

            val webURL = "https://www.instagram.com/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(webURL))
            startActivity(intent)
        }

        val buttonPhone3 = findViewById<Button>(R.id.button3)
        buttonPhone3.setOnClickListener{
            Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()

            val phonenumber = "085155334028"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phonenumber"))
            startActivity(intent)
        }
    }
}