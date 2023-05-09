package com.example.horus.data.network

import com.example.horus.data.model.RegisterData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {

    @POST("users/register")
    fun register(@Body body: RegisterData) : Call<Unit>
}