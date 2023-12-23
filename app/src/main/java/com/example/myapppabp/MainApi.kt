package com.example.myapppabp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapppabp.Api.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainApi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_api)

        val morty = findViewById<RecyclerView>(R.id.ry_morty)
        ApiConfig.getService().getMorty().enqueue(object : Callback<ResponseMorty> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<ResponseMorty>, response: Response<ResponseMorty>) {
                if (response.isSuccessful) {
                    val responseMorty = response.body()
                    val dataMorty = responseMorty?.results
                    val mortyAdapter = MortyAdapter(dataMorty)
                    morty.apply {
                        layoutManager =LinearLayoutManager(this@MainApi)
                        setHasFixedSize(true)
                        mortyAdapter.notifyDataSetChanged()
                        adapter = mortyAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ResponseMorty>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        } )
    }
}