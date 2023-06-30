package com.example.horus.data.model

import com.google.gson.annotations.SerializedName


data class DataProfile(

    @SerializedName("date_of_birth" ) var dateOfBirth : String? = null,
    @SerializedName("phone"         ) var phone       : Int?    = null,
    @SerializedName("code_country"  ) var codeCountry : String? = null,
    @SerializedName("user_id"       ) var userId      : Int?    = null

)
