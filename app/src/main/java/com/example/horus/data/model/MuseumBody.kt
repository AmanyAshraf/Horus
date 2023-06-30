package com.example.horus.data.model

import com.google.gson.annotations.SerializedName


data class MuseumBody (

    @SerializedName("id"                  ) var id                 : Int?    = null,
    @SerializedName("name"                ) var name               : String? = null,
    @SerializedName("description"         ) var description        : String? = null,
    @SerializedName("location"            ) var location           : String? = null,
    @SerializedName("image"               ) var image              : String? = null,
    @SerializedName("m_type"              ) var mType              : String? = null,
    @SerializedName("website"             ) var website            : String? = null,
    @SerializedName("review_rate"         ) var reviewRate         : Int?    = null,
    @SerializedName("suggested_durations" ) var suggestedDurations : String? = null,
    @SerializedName("how_to_get_there"    ) var howToGetThere      : String? = null

)