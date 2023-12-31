package com.example.mealrecipe.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mealrecipe.models.MealResponse
import com.example.mealrecipe.utils.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealViewModel() : ViewModel() {
    private val retrofitClient = RetrofitClient.instance
    private val viewModelScope = CoroutineScope(Dispatchers.IO)

    private val _mealResponse = MutableLiveData<MealResponse>()
    val mealResponse: LiveData<MealResponse> get() = _mealResponse

    fun getMeal(options: Map<String?, String?>){
        val mealService = retrofitClient.apiService

        viewModelScope.launch{
            try {
                val mealResponse = mealService.getMeal(options)

                if (mealResponse.isSuccessful) {
//                    _userResponse.postValue(userResponse.body())
                    Log.d("View Model", "code: ${mealResponse.code()}")
                    Log.d("View Model", "code: ${mealResponse.body()?.data}")
                    _mealResponse.postValue(mealResponse.body())
                } else {
                    // Handle the error, for now, just log it
                    Log.d("View Model error", "code: ${mealResponse.code()}")
                }
            } catch (e: Exception) {
                // Handle network or other exceptions
                Log.e("View Model error", "Error fetching users", e)
            }
        }
    }
}