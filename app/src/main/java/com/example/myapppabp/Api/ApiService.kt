package com.example.myapppabp.Api

import retrofit2.Call
import com.example.myapppabp.ResponseMorty
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    fun getMorty() : Call<ResponseMorty>

}