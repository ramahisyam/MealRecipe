package com.example.mealrecipe.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mealrecipe.databinding.ActivityMealBinding
import com.example.mealrecipe.viewmodels.MealViewModel

class MealActivity : AppCompatActivity() {

    private val mealViewModel by viewModels<MealViewModel>()
    private lateinit var binding: ActivityMealBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val categories = intent.getStringExtra("CATEGORY_NAME")
        val queries = intent.getStringExtra("QUERY")
        val options = mapOf(queries to categories)
        mealViewModel.getMeal(options)

        binding.tvCategory.text = categories

        val rvMeal = binding.rvMeal
        rvMeal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        mealViewModel.mealResponse.observe(this){mealResponse ->
            val mealAdapter = MealAdapter(mealResponse.data)
            rvMeal.adapter = mealAdapter
        }
    }
}