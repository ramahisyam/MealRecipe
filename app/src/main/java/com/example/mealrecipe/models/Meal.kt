package com.example.mealrecipe.models

import com.google.gson.annotations.SerializedName

data class Meal(
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val thumbnail: String,
    @SerializedName("idMeal") val id: String
)
