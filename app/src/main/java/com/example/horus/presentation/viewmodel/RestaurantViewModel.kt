package com.example.horus.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horus.data.model.BankBody
import com.example.horus.data.model.RestaurantBody
import com.example.horus.domain.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel  @Inject constructor(
    private val dataRepository: DataRepository
) : ViewModel() {
    private var _mutableResponse = MutableLiveData<List<RestaurantBody>>()
    val response: LiveData<List<RestaurantBody>> = _mutableResponse

    init {
        getRestaurantByCity()
    }
    fun getRestaurantByCity(){
        viewModelScope.launch {
            _mutableResponse.value=  dataRepository.getRestaurantByCity()
        }
    }
}