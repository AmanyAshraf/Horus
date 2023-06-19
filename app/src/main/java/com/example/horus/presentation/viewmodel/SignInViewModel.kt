package com.example.horus.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horus.data.model.LoginBody
import com.example.horus.data.model.LoginData
import com.example.horus.domain.repository.DataRepository
import com.example.horus.presentation.ui.activity.LoginActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SignInViewModel  @Inject constructor(
    private val dataRepository: DataRepository
) : ViewModel() {

    fun login(email :String, password:String) : LiveData<LoginData?>{
        val login = MutableLiveData<LoginData?>()
        viewModelScope.launch {
            dataRepository.login(email,password).enqueue(object : Callback<LoginData> {
                override fun onResponse(call: Call<LoginData>, response: Response<LoginData>) {
                    if (response.isSuccessful){
                        login.value=response.body()
                        LoginActivity.token = response.body()?.access
                    }
                }
                override fun onFailure(call: Call<LoginData>, t: Throwable) {
                    login.value = LoginData("","")
                }
            })
        }

        return login
    }

}