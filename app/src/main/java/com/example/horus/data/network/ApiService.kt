package com.example.horus.data.network

import com.example.horus.data.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("/users/register/")

    fun register(@Body body: RegisterData) : Call<Unit>


    @POST("/auth/jwt/create/")
    fun login(@Body body: LoginBody) : Call<LoginData>

    @GET("/api/service/bank/")
    suspend fun getBankByCity(@Query("location")query:String) :List<BankBody>

   /* @GET("/api/service/bank/1/")
    suspend fun getBankById(@Body id:String) :Call<BankBody>*/

    @GET("/api/service/restaurant/")
    suspend fun getRestaurantByCity(@Query("location")query:String) :List<RestaurantBody>

    /*@GET("/api/service/restaurant/1/")
    suspend fun getRestaurantById(@Body id:String) :Call<RestaurantBody>*/

    @GET("/api/service/hotel/")
    suspend fun getHotelByCity(@Query("location")query:String) : List<HotelBody>

  /*  @GET("/api/service/hotel/1/")
    suspend fun getHotelById(@Body id:String) : HotelBody*/

/* @GET("/api/search/")
    fun search(@Body query:String) :Call<Unit>*/


}