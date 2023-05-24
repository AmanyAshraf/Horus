package com.example.horus.data.model

import com.google.gson.annotations.SerializedName


data class RestaurantBody (

    @SerializedName("id"          ) var id          : Int?    = null,
    @SerializedName("name"        ) var name        : String? = null,
    @SerializedName("location"    ) var location    : String? = null,
    @SerializedName("image"       ) var image       : String? = null,
    @SerializedName("description" ) var description : String? = null,
    @SerializedName("telephone"   ) var telephone   : String? = null,
    @SerializedName("website"     ) var website     : String? = null,
    @SerializedName("open_from"   ) var openFrom    : String? = null,
    @SerializedName("open_to"     ) var openTo      : String? = null,
    @SerializedName("rating"      ) var rating      : Int?    = null,
    @SerializedName("cuisines"    ) var cuisines    : String? = null,
    @SerializedName("features"    ) var features    : String? = null,
    @SerializedName("meals"       ) var meals       : String? = null,
    @SerializedName("type_r"      ) var typeR       : String? = null,
    @SerializedName("menu"        ) var menu        : String? = null

)
