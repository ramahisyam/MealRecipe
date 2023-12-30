package com.example.mealrecipe.utils

import com.example.mealrecipe.repositories.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.themealdb.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)

    companion object {
        val instance: RetrofitClient by lazy { RetrofitClient() }
    }
}