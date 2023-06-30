package com.example.horus.data.model

import com.google.gson.annotations.SerializedName


data class SearchBody (
    @SerializedName("id"           ) var id          : Int?    = null,
    @SerializedName("name"         ) var name        : String? = null,
    @SerializedName("location"     ) var location    : String? = null,
    @SerializedName("description"  ) var description : String? = null,
    @SerializedName("image"        ) var image       : String? = null,
    @SerializedName("service_type" ) var serviceType : String? = null

)
