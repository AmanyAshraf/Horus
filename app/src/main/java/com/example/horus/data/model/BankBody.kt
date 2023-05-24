package com.example.horus.data.model


import com.google.gson.annotations.SerializedName


data class BankBody (

    @SerializedName("id"          ) var id          : Int?    = null,
    @SerializedName("name"        ) var name        : String? = null,
    @SerializedName("location"    ) var location    : String? = null,
    @SerializedName("image"       ) var image       : String? = null,
    @SerializedName("description" ) var description : String? = null,
    @SerializedName("link"        ) var link        : String? = null,
    @SerializedName("telephone"   ) var telephone   : String? = null

)