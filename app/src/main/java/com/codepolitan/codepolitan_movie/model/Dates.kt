package com.codepolitan.codepolitan_movie.model

import com.google.gson.annotations.SerializedName

/**
 * Created by yudisetiawan on 11/4/17.
 */

data class Dates(
        @SerializedName("maximum") val maximum: String,
        @SerializedName("minimum") val minimum: String
)