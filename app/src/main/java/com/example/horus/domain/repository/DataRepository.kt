package com.example.horus.domain.repository

import com.example.horus.data.model.DataProfile
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
    suspend fun createProfile(dateOfBirth:String,phone:Int,codeCountry:String,userId:Int)
            = withContext(Dispatchers.IO){
        api.createProfile(DataProfile(dateOfBirth,phone,codeCountry, userId))
    }
}