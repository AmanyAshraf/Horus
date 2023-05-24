package com.example.horus.data.model

import com.google.gson.annotations.SerializedName


data class LoginData (

    @SerializedName("refresh" ) var refresh : String? = null,
    @SerializedName("access"  ) var access  : String? = null

)