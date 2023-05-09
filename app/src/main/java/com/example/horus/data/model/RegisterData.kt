package com.example.horus.data.model

import com.google.gson.annotations.SerializedName


data class RegisterData (

    @SerializedName("name"                  ) var name                 : String? = null,
    @SerializedName("username"              ) var username             : String? = null,
    @SerializedName("email"                 ) var email                : String? = null,
    @SerializedName("password"              ) var password             : String? = null,
    @SerializedName("password_confirmation" ) var passwordConfirmation : String? = null

)
