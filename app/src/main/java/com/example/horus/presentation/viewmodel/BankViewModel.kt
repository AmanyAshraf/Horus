package com.example.horus.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horus.data.model.BankBody
import com.example.horus.domain.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BankViewModel  @Inject constructor(
    private val dataRepository: DataRepository
) : ViewModel() {
    private var _mutableResponse = MutableLiveData<List<BankBody>>()
    val response: LiveData<List<BankBody>> = _mutableResponse

    init {
        getBankByCity()
    }
    fun getBankByCity(){
        viewModelScope.launch {
            _mutableResponse.value=  dataRepository.getBankByCity()
        }
    }
}