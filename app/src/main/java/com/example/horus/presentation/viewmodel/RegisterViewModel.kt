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
class RegisterViewModel@Inject constructor(
    private val dataRepository: DataRepository
) : ViewModel() {

    fun register( name:String,userName:String, email:String, password:String,passwordConfirmation:String) : LiveData<Int?> {
        val register = MutableLiveData<Int?>()
        viewModelScope.launch {
            dataRepository.register(name,userName, email, password,passwordConfirmation)
                .enqueue(object : Callback<Unit> {
                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                        if (response.isSuccessful) {
                            register.value=1
                        } else {
                            register.value = 2
                        }
                    }
                    override fun onFailure(call: Call<Unit>, t: Throwable) {
                        register.value = -1
                    }
                })
        }

        return register
    }

}