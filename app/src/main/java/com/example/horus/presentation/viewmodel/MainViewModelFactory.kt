package com.example.horus.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.horus.domain.repository.DataCreateProfile

class MainViewModelFactory(
    private val dataCreateProfile: DataCreateProfile
) :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CreateProfileViewModel (dataCreateProfile)as T
    }
}