package com.example.horus.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.horus.presentation.ui.activity.FirebaseUserLiveData

class LoginViewModel : ViewModel() {
    enum class AuthenticationState {
        Success, Failed
    }

    val authenticationState = FirebaseUserLiveData().map { user ->
        if (user != null) {
            AuthenticationState.Success
        } else {
            AuthenticationState.Failed
        }
    }
}