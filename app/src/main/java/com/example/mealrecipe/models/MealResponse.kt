package com.example.mealrecipe.models

import com.google.gson.annotations.SerializedName

data class MealResponse(
    @SerializedName("meals") val data: List<Meal>
)
