package com.example.mealrecipe.repositories

import com.example.mealrecipe.models.CategoryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/api/json/v1/1/list.php")
    suspend fun getCategory(@Query("c") c: String): Response<CategoryResponse>
}