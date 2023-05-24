package com.example.horus.domain.repository

import com.example.horus.data.model.DataProfile
import com.example.horus.data.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

private val api: ApiService
    get() {
        TODO()
    }

@Singleton

class DataCreateProfile@Inject constructor(

){
    suspend fun createProfile(dateOfBirth:String,phone:Int,codeCountry:String,userId:Int)
    = withContext(Dispatchers.IO){
        api.createProfile(DataProfile(dateOfBirth,phone,codeCountry, userId))
    }

}