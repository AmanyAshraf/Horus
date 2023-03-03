package com.example.horus.presentation.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

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