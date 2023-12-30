package com.example.mealrecipe.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mealrecipe.models.CategoryResponse
import com.example.mealrecipe.utils.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {
    private val retrofitClient = RetrofitClient.instance
    private val viewModelScope = CoroutineScope(Dispatchers.IO)

    private val _categoryResponse = MutableLiveData<CategoryResponse>()
    val categoryResponse: LiveData<CategoryResponse> get() = _categoryResponse

    fun getCategory(){
        val categoryService = retrofitClient.apiService

        viewModelScope.launch{
            try {
                val categoryResponse = categoryService.getCategory("list")

                if (categoryResponse.isSuccessful) {
//                    _userResponse.postValue(userResponse.body())
                    Log.d("View Model", "code: ${categoryResponse.code()}")
                    Log.d("View Model", "code: ${categoryResponse.body()?.data}")
                    _categoryResponse.postValue(categoryResponse.body())
                } else {
                    // Handle the error, for now, just log it
                    Log.d("View Model error", "code: ${categoryResponse.code()}")
                }
            } catch (e: Exception) {
                // Handle network or other exceptions
                Log.e("View Model error", "Error fetching users", e)
            }
        }
    }
}