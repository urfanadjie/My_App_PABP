package com.example.myapppabp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_2)

        val buttonLogin2 = findViewById<Button>(R.id.buttonlogin)
        buttonLogin2.setOnClickListener{
            Toast.makeText(this@MainActivity, "Berhasil Login", Toast.LENGTH_SHORT).show()

            //Ambil text dari view EditText
            val editTextUsername = findViewById<EditText>(R.id.edittext_username_1)
            val editTextPassword = findViewById<EditText>(R.id.edittext_password_1)

            //Coba tempatkan disini sebelum start activity
//            val intent = Intent(this, MainActivity3::class.java)

            //Deklarasi bundle
//            val bundle = Bundle()

            //Ambil value jadi string EditText
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            //Masukkan dalam var intent
//            intent.putExtra("USERNAME", username)
//            intent.putExtra("PASSWORD", password)

            //Masukkan dalam var intent dengan bundle
//            bundle.putString("USERNAME", username)
//            bundle.putString("PASSWORD", password)

            //Masukkan dalam variabel dgn parcelable
            val userData = MainActivity3UserData(username, password)

            //baru tempatkan ini setelahnya (jika dengan bundle) atapun lainnya
//            intent.putExtras(bundle)

            //jika dgn parcelable
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("USER_DATA", userData)

            //Start intent activity
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