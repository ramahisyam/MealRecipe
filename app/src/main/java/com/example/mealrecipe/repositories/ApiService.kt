package com.example.mealrecipe.repositories

import com.example.mealrecipe.models.AreaResponse
import com.example.mealrecipe.models.CategoryResponse
import com.example.mealrecipe.models.MealResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {
    @GET("/api/json/v1/1/list.php")
    suspend fun getCategory(@Query("c") c: String): Response<CategoryResponse>

    @GET("/api/json/v1/1/list.php")
    suspend fun getArea(@Query("a") c: String): Response<AreaResponse>

    @GET("/api/json/v1/1/filter.php")
    suspend fun getMeal(@QueryMap options: Map<String?, String?>): Response<MealResponse>

}