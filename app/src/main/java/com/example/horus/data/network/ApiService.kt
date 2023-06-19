package com.example.horus.data.network

import com.example.horus.data.model.LoginBody
import com.example.horus.data.model.LoginData
import com.example.horus.data.model.RegisterData
import com.example.horus.data.model.DataProfile
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("/users/register/")
     fun register(@Body body: RegisterData) : Call<Unit>
    @POST("api/profiles")
    fun createProfile(@Body body: DataProfile):Call<Unit>

    @POST("/auth/jwt/create/")
    fun login(@Body body: LoginBody) : Call<LoginData>


}