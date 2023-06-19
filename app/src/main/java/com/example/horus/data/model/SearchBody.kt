package com.example.horus.data.model

import com.google.gson.annotations.SerializedName


data class SearchBody (

    @SerializedName("q" ) var q : String? = null

)