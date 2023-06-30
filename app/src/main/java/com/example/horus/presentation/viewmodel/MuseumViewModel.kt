package com.example.horus.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horus.data.model.MuseumBody
import com.example.horus.data.model.RestaurantBody
import com.example.horus.data.model.SearchBody
import com.example.horus.domain.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MuseumViewModel @Inject constructor(
    private val dataRepository: DataRepository
) : ViewModel() {
    private var _mutableResponse = MutableLiveData<List<MuseumBody>>()
    val response: LiveData<List<MuseumBody>> = _mutableResponse

    init {
        getMuseums()
    }
    fun getMuseums(){
        viewModelScope.launch {
            dataRepository.getMuseums().enqueue(object : Callback<List<MuseumBody>> {
                override fun onResponse(call: Call<List<MuseumBody>>, response: Response<List<MuseumBody>>) {
                    if (response.isSuccessful){
                        _mutableResponse.value=  response.body()
                    }
                }
                override fun onFailure(call: Call<List<MuseumBody>>, t: Throwable) {
                    //
                    _mutableResponse.value = mutableListOf()
                }
            })
        }
    }
}