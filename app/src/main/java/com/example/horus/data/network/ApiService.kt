package com.example.horus.data.network

import com.example.horus.data.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @POST("/users/register/")

    fun register(@Body body: RegisterData) : Call<Unit>


    @POST("/auth/jwt/create/")
    fun login(@Body body: LoginBody) : Call<LoginData>

    @GET("/api/service/bank/")
    suspend fun getBankByCity(@Query("location")query:String) :List<BankBody>

   /* @GET("/api/service/bank/{id}/")
    suspend fun getBankById(@Path("id") id:String) : BankBody*/

    @GET("/api/service/restaurant/")
    suspend fun getRestaurantByCity(@Query("location")query:String) :List<RestaurantBody>

   /* @GET("/api/service/restaurant/{id}/")
    suspend fun getRestaurantById(@Path("id") id:String) : RestaurantBody*/

    @GET("/api/service/hotel/")
    suspend fun getHotelByCity(@Query("location")query:String) : List<HotelBody>

   /* @GET("/api/service/hotel/{id}/")
    suspend fun getHotelById(@Path("id") id:String) : HotelBody*/

    @GET("/api/search/")
    fun search(@Query("q") query:String) : Call<List<SearchBody>>

    @GET("api/museums/location/first/")
    fun getMuseums(@Query("location") query:String) : Call<List<MuseumBody>>


}