package com.example.mealrecipe.models

import com.google.gson.annotations.SerializedName

data class AreaResponse(
    @SerializedName("meals") val data: List<Area>
)
