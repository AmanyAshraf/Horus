package com.example.horus.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horus.domain.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class CreateProfileViewModel@Inject constructor(
    private val dataRepository: DataRepository
):ViewModel() {
    fun createProfile (dateOfBirth:String, phone:Int, codeCountry:String, userId:Int):LiveData<Int?> {
        val createProfile = MutableLiveData<Int?>()
        viewModelScope.launch {
            dataRepository.createProfile(dateOfBirth, phone, codeCountry, userId)
                .enqueue(object :Callback<Unit>{
                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                        if (response.isSuccessful) {
                            createProfile.value=1
                        } else {
                            createProfile.value = 2
                        }
                    }

                    override fun onFailure(call: Call<Unit>, t: Throwable) {
                        createProfile.value =-1
                    }

                })
        }
        return createProfile
    }
}