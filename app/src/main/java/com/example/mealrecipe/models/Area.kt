package com.example.mealrecipe.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Area(
    @SerializedName("strArea") val name: String
)