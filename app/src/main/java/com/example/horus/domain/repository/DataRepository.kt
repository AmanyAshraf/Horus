package com.example.horus.domain.repository

import com.example.horus.data.model.LocationBody
import com.example.horus.data.model.LoginBody
import com.example.horus.data.model.LoginData
import com.example.horus.data.model.RegisterData
import com.example.horus.data.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepository @Inject constructor(
    private val api: ApiService
){
    suspend fun register(name:String,userName:String, email:String, password:String,passwordConfirmation:String)
        = withContext(Dispatchers.IO) {
        api.register(RegisterData(name,userName,email,password,passwordConfirmation) )
    }
    suspend fun login(email :String, password:String)
            = withContext(Dispatchers.IO) {
        api.login(LoginBody(email , password) )
    }
    suspend fun getHotelByCity() = withContext(Dispatchers.IO) {
        api.getHotelByCity("mansoura")
    }
    suspend fun getBankByCity() = withContext(Dispatchers.IO) {
        api.getBankByCity("mansoura")
    }
    suspend fun getRestaurantByCity() = withContext(Dispatchers.IO) {
        api.getRestaurantByCity("mansoura")
    }
    suspend fun search(query : String) = withContext(Dispatchers.IO) {
        api.search(query)
    }
    suspend fun getMuseums() = withContext(Dispatchers.IO) {
        api.getMuseums("giza")
    }
}