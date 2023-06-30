package com.example.horus.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horus.data.model.LoginData
import com.example.horus.data.model.RestaurantBody
import com.example.horus.data.model.SearchBody
import com.example.horus.domain.repository.DataRepository
import com.example.horus.presentation.ui.activity.LoginActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val dataRepository: DataRepository
) : ViewModel() {
    private var _mutableResponse = MutableLiveData<List<SearchBody>>()
    val response: LiveData<List<SearchBody>> = _mutableResponse


    fun search(query :String){
        viewModelScope.launch {
            dataRepository.search(query = query).enqueue(object : Callback<List<SearchBody>> {
                override fun onResponse(call: Call<List<SearchBody>>, response: Response<List<SearchBody>>) {
                    if (response.isSuccessful){
                        _mutableResponse.value=  response.body()

                    }
                }
                override fun onFailure(call: Call<List<SearchBody>>, t: Throwable) {
                    //
                    _mutableResponse.value = mutableListOf()
                }
            })
        }
    }
}