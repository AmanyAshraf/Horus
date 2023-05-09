package com.example.horus.domain.repository

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
}