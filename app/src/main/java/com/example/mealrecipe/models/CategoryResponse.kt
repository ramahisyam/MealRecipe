package com.example.mealrecipe.models

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("meals") val data: List<Category>
)
