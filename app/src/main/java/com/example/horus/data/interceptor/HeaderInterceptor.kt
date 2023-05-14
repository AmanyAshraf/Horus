package com.example.horus.data.interceptor

import com.example.horus.presentation.ui.activity.LoginActivity
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

     val builder =   chain.request().newBuilder()
         .addHeader("Authorization", "Bearer " + LoginActivity.token)
         .build()

        return chain.proceed(builder)
    }
}