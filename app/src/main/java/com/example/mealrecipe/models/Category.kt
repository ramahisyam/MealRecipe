package com.example.mealrecipe.models

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("strCategory") val name: String
)
