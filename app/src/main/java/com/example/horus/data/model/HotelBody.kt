package com.example.horus.data.model

import com.google.gson.annotations.SerializedName


data class HotelBody (

    @SerializedName("id"                  ) var id                 : Int?    = null,
    @SerializedName("name"                ) var name               : String? = null,
    @SerializedName("location"            ) var location           : String? = null,
    @SerializedName("image"               ) var image              : String? = null,
    @SerializedName("description"         ) var description        : String? = null,
    @SerializedName("review"              ) var review             : Int?    = null,
    @SerializedName("cleanlinsess_review" ) var cleanlinsessReview : Int?    = null,
    @SerializedName("service_review"      ) var serviceReview      : String? = null,
    @SerializedName("value_review"        ) var valueReview        : String? = null,
    @SerializedName("language_spoken"     ) var languageSpoken     : String? = null

)
