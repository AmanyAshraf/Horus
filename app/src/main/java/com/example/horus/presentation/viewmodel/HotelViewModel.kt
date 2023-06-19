package com.example.horus.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horus.data.model.HotelBody
import com.example.horus.domain.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotelViewModel  @Inject constructor(
    private val dataRepository: DataRepository
) : ViewModel() {
    private var _mutableResponse = MutableLiveData<List<HotelBody>>()
    val response: LiveData<List<HotelBody>> = _mutableResponse

    init {
        getHotelByCity()
    }
    fun getHotelByCity(){
        viewModelScope.launch {
            _mutableResponse.value=  dataRepository.getHotelByCity()
        }
    }

}